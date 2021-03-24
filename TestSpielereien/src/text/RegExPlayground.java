package text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegExPlayground {
	private Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
	
	@Test
	public void sollteVorhandenSein() {
		
		String text1 = "Erster Auftrag im 2013-09-14 Portal erstellt :)";
		String possibleMatch = null;
		Matcher m = this.pattern.matcher(text1);
		if (m.find()) {
			possibleMatch = m.group();
			System.out.println("Match gefunden: " + possibleMatch + ", alles gut!");
		} else {
			System.out.println("Kein Match gefunden. Houston...");
		}
		Assertions.assertEquals("2013-09-14", possibleMatch);
	}
	
	@Test
	public void sollteNichtVorhandenSein() {
		String text1 = "Erster Auftrag im Portal erstellt :)";
		String possibleMatch = null;
		Matcher m = this.pattern.matcher(text1);
		if (m.find()) {
			possibleMatch = m.group(1);
			System.out.println("Match gefunden: " + possibleMatch + ", Houston...");
		} else {
			System.out.println("Kein Match gefunden, alles gut");
		}
		Assertions.assertEquals(null, possibleMatch);
	}
	
	@Test 
	public void pruefung1() {
		String cand = "201234567801";
		String pattern = "^.*01$";
		boolean res = cand.matches(pattern);
		System.out.println("Prüfe " + cand + " gegen Regex " + pattern + " --> " + res);
		Assertions.assertTrue(res, pattern + " passt nicht auf " + cand);
	}

	@Test 
	public void pruefung2() {
		String cand = "201234567802";
		String pattern = "^.*01$";
		boolean res = cand.matches(pattern);
		System.out.println("Prüfe " + cand + " gegen Regex " + pattern + " --> " + res);		
		Assertions.assertFalse(res, pattern + " passt nicht auf " + cand);
	}
	
	@Test 
	public void pruefung3() {
		String cand = "201234567801";
		String pattern = "^\\d{10}01$";
		boolean res = cand.matches(pattern);
		System.out.println("Prüfe " + cand + " gegen Regex " + pattern + " --> " + res);		
		Assertions.assertTrue(res, pattern + " passt nicht auf " + cand);
	}
	
	@Test 
	public void pruefung4() {
		String cand = "201234567801";
		String pattern = "^201234567801$";
		boolean res = cand.matches(pattern);
		System.out.println("Prüfe " + cand + " gegen Regex " + pattern + " --> " + res);		
		Assertions.assertTrue(res, pattern + " passt nicht auf " + cand);
	}	
	
	@Test 
	public void pruefung5() {
		String cand = "20123456701";
		String pattern = "^\\d{10}01$";
		boolean res = cand.matches(pattern);
		System.out.println("Prüfe " + cand + " gegen Regex " + pattern + " --> " + res);		
		Assertions.assertFalse(res, pattern + " passt nicht auf " + cand);
	}
	
	@Test 
	public void pruefung6() {
		String cand = "201234567801";
		String pattern = "^\\d{9}01$";
		boolean res = cand.matches(pattern);
		System.out.println("Prüfe " + cand + " gegen Regex " + pattern + " --> " + res);		
		Assertions.assertFalse(res, pattern + " passt nicht auf " + cand);
	}
	
	@Test 
	public void pruefung7() {
		String cand = "201234567801";
		String pattern = "^201234567801$";
		boolean res = cand.matches(pattern);
		System.out.println("Prüfe " + cand + " gegen Regex " + pattern + " --> " + res);		
		Assertions.assertTrue(res, pattern + " passt nicht auf " + cand);
	}
	
}
