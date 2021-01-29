package text;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringSpielerei {

	@Test
	void test1() {
		String meinTestText = "*Haus*Grund*";
		String ergebnis = meinTestText.substring(0, meinTestText.length() - 1);
		System.out.println(meinTestText + " --> " + ergebnis);
		Assertions.assertEquals("eins", "eins");
	}

	@Test
	void test2() {
		String meinTestText = "*Haus*Grund*";
		System.out.println(meinTestText);
		while (meinTestText.startsWith("*") || meinTestText.startsWith("?")) {
			String zwischen = meinTestText.substring(1);
			System.out.println(meinTestText + " --> " + zwischen);
			meinTestText = zwischen;
		}

		while (meinTestText.endsWith("*") || meinTestText.endsWith("?")) {
			String zwischen = meinTestText.substring(0, meinTestText.length() - 1);
			System.out.println(meinTestText + " --> " + zwischen);
			meinTestText = zwischen;
		}

		String zwischen = meinTestText.replaceAll("\\*", "%");
		System.out.println(meinTestText + " --> " + zwischen);
		meinTestText = zwischen;

		System.out.println("==> " + meinTestText);
	}

	@Test
	void test3() {

		System.out.println(
				"Soll die Einrichtungsgruppe\n\n\"SOME NAME\"\n\nwirklich gelöscht werden? \n\nDiese Aktion kann nicht rückgängig gemacht werden!");
	}
}
