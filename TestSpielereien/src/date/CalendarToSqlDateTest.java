/**
 * 
 */
package date;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

/**
 * @author Z133111
 *
 */
class CalendarToSqlDateTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() {
		GregorianCalendar cal = new GregorianCalendar();
		int jahr = cal.get(Calendar.YEAR);
		int monat = cal.get(Calendar.MONTH) + 1;
		int tag = cal.get(Calendar.DAY_OF_MONTH); 
		String kette = jahr + "-" + monat + "-" + tag;
		System.out.println(kette);
		java.sql.Date datum = java.sql.Date.valueOf(kette);
		Assertions.assertEquals(kette, datum.toString());
	}
	
	@Test
	void test2() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String kette = sdf.format(cal.getTime());
		java.sql.Date datum = new java.sql.Date(cal.getTimeInMillis());
		Assertions.assertEquals(kette, datum.toString());
	}
	
	@Test
	void test3() {
		Calendar mlast = Calendar.getInstance();
		Calendar mfirst = Calendar.getInstance();
		mfirst.set(2019, Calendar.MAY, 1, 0, 0, 0);
		mlast.set(2019, Calendar.MAY, 31, 14, 30, 2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Initial");
		System.out.println(sdf.format(mfirst.getTime()) + "..." + sdf.format(mlast.getTime()));
		mlast.add(Calendar.MONTH, 1);
		System.out.println("+ 1 Monat");
		System.out.println(sdf.format(mfirst.getTime()) + "..." + sdf.format(mlast.getTime()));
		mlast.set(Calendar.DAY_OF_MONTH, mlast.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("Monatsletzter");
		System.out.println(sdf.format(mfirst.getTime()) + "..." + sdf.format(mlast.getTime()));
		mlast.set(Calendar.HOUR_OF_DAY, 0);
		mlast.set(Calendar.MINUTE, 0);
		mlast.set(Calendar.SECOND, 0);
		System.out.println("Zeitanteil eliminiert");
		System.out.println(sdf.format(mfirst.getTime()) + "..." + sdf.format(mlast.getTime()));
		mlast.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println("Monatserster");
		System.out.println(sdf.format(mfirst.getTime()) + "..." + sdf.format(mlast.getTime()));
		int i = 0;
		while (mlast.after(mfirst)) {
			i = i + 1;
			System.out.println("Durchlauf " + i);
			System.out.println(sdf.format(mfirst.getTime()) + "..." + sdf.format(mlast.getTime()));
			mfirst.add(Calendar.MONTH, 1);
		}
		Assertions.assertTrue(true);
	}

}
