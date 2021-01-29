package text;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Darstellung {

	NumberFormat df1 = null;
	NumberFormat df2 = null;
	Map<String, String> quelle = null;

	@BeforeEach
	public void initializeNumbers() {
		this.df1 = NumberFormat.getNumberInstance(Locale.GERMAN);
		this.df1.setMinimumFractionDigits(2);
		this.df1.setMaximumFractionDigits(2);
		this.df1.setMinimumIntegerDigits(1);
		this.df1.setRoundingMode(RoundingMode.HALF_UP);

		this.df2 = NumberFormat.getCurrencyInstance(Locale.GERMANY);

		this.quelle = new HashMap<String, String>();
		this.quelle.put("14543.5531", "14.543,55");
		this.quelle.put("0.41", "0,41");
		this.quelle.put("0.2", "0,20");
		this.quelle.put("14", "14,00");
		this.quelle.put("143.5", "143,50");
		this.quelle.put("-14543.5531", "-14.543,55");
		this.quelle.put("-14", "-14,00");
		this.quelle.put("-143.5", "-143,50");
		this.quelle.put("0", "0,00");
		this.quelle.put("14543.5571", "14.543,56");
	}

	@Test
	public void zeigeZahl() {
		for (String zahl : this.quelle.keySet()) {
			BigDecimal nummer = new BigDecimal(zahl);
			String output = this.df1.format(nummer);
			String expected = this.quelle.get(zahl);
			System.out.println(zahl + " --> " + output + " (" + expected + ")");
			Assertions.assertEquals(expected, output);
		}
	}

	@Test
	public void zeigeCurrency() {
		for (String zahl : this.quelle.keySet()) {
			BigDecimal nummer = new BigDecimal(zahl);
			String currency = this.df2.format(nummer);
			String expected = this.quelle.get(zahl);
			System.out.println(zahl + " --> " + currency + " (" + expected + " €)");
			Assertions.assertEquals(expected + " €", currency);
		}

		System.out.println(this.df2.getCurrency().getDisplayName());
		System.out.println(this.df2.getCurrency().getSymbol());
	}

	@Test
	public void invalidValues() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.df1.format("vierzehn");
		});
	}
}

