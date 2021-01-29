package text;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class StringSortierung {
	private TreeSet<String> exists = null;
	
	@Test
	public void zeigeListe() {
		this.erstelleListe();
		SortedSet<String> unter = this.exists.subSet("000", "AAA");
//		SortedSet<String> unter = this.exists;
		
		for (String schluessel : unter) {
			System.out.println(schluessel);
		}
	}

	/**
	 * Erzeugt ein TreeSet aller möglichen Werte als Keys. 
	 */
	private void erstelleListe() {
		// Dreistellig base36 sind 000 - ZZZ
		int startwert = Integer.parseInt(this.convertFromBase36ToBase10("000"));
		int endwert = Integer.parseInt(this.convertFromBase36ToBase10("ZZZ"));
		
		this.exists = new TreeSet<String>();
		
		for (int i = startwert; i <= endwert; i++) {
			String base36 = Integer.toString(i, 36);
			base36 = base36.toUpperCase();
			while(base36.length() < 3) {
				base36 = "0" + base36;
			}
			this.exists.add(base36);
		}
	}
	
	private String convertFromBase10ToBase36(String str) {
		return this.convertFromBaseToBase(str, 10, 36);
		
	}
	
	private String convertFromBase36ToBase10(String str) {
		return this.convertFromBaseToBase(str, 36, 10);
	}
	
	/**
	 * Konvertiert von der angegebenen Basis in die Zielbasis
	 * @param str String-Repräsentation der Quell-Zahl in der Quell-Basis
	 * @param fromBase Quellbasis
	 * @param toBase Ziel-Basis
	 * @return String-Repräsentation der Zahl in der Ziel-Basis
	 */
	private String convertFromBaseToBase(String str, int fromBase, int toBase) {
		return Integer.toString(Integer.parseInt(str, fromBase), toBase);
	}
}
