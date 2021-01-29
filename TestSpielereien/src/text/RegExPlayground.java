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

}
