package suche;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LetztenFinder {
	private boolean[] vergebenListe = new boolean[1000];
	private int anzahlPruefschritte = 0;
	private int gesucht = 940;
	
	@BeforeEach
	private void initializeArray() {
		for (int i = 0; i < this.gesucht; i++) {
			this.vergebenListe[i] = true;
		}
		
		for (int i = this.gesucht; i < 1000; i++) {
			this.vergebenListe[i] = false;
		}
		this.anzahlPruefschritte = 0;
	}
	
	@Test
	public void findeRekursiv() {
		int gefunden = this.findeRekursiv(0, 999);
		System.out.println("Geteilt gefundener erster freier Wert nach " + this.anzahlPruefschritte + " Prüfschritten: " + gefunden);
		Assertions.assertEquals(this.gesucht, gefunden);
	}
	
	@Test
	public void findeLinear() {
		int gefunden = this.findeLinear(0, 999);
		System.out.println("Linear gefundener erster freier Wert nach " + this.anzahlPruefschritte + " Prüfschritten: " + gefunden);
		Assertions.assertEquals(this.gesucht, gefunden);
	}	
	
	private int findeLinear(int beginn, int ende) {
		for (int i = 999; i > -1; i--) {
			this.anzahlPruefschritte = this.anzahlPruefschritte + 1;
			if (this.vergebenListe[i]) {
				return i + 1;
			}
		}
		
		return 0;
	}
	
	private int findeRekursiv(int beginn, int ende) {
		this.anzahlPruefschritte = this.anzahlPruefschritte + 1;
		System.out.println("Schritt " + this.anzahlPruefschritte + ": Intervall " + beginn + ".." + ende);
		int mitte = (ende + beginn) / 2;
		boolean endeErreicht = false;
		if (mitte == beginn) {
			System.out.println("Intervallänge 1 oder 2 - keine weitere Prüfung");
			endeErreicht = true;
		}
		System.out.println("Mittelwert: " + mitte + " --> " + this.vergebenListe[mitte]);
		if (this.vergebenListe[mitte]) {
			if (endeErreicht) {
				return ende;
			}
			return this.findeRekursiv(mitte + 1, ende);
		} else {
			if (endeErreicht) {
				return mitte;
			}
			return this.findeRekursiv(beginn, mitte);
		}
	}
}
