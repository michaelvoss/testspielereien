package text;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Hashing {

	HashMap<String, String> dictionary;
	HashCalculator calc = HashCalculator.getInstance();

	@BeforeEach
	public void initializeText() {
		this.dictionary = new HashMap<String, String>();
		this.dictionary.put("This!sThePa22wordForLSS", "23FE0323AB1CBDAC3A904C12C58ADA0C");
		this.dictionary.put("Wls-PROD!Pa22wordForLSS", "14C35DFBCD3932B6808A56E764FCCCAA");
		this.dictionary.put("TheAdmin!Pa22wordForLSS", "74D6BC5AED17F505F3851499B27B963A");
	}

	@Test
	public void hashIt() {
		BufferedWriter outputUTF8 = null;
		BufferedWriter outputANSI = null;
		try {
			outputUTF8 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\temp\\encrypted_UTF8.txt"),
					StandardCharsets.UTF_8));
		} catch (FileNotFoundException e) {
			// Dann nicht...
		}
		try {
			outputANSI = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\temp\\encrypted_ANSI.txt"),
					StandardCharsets.ISO_8859_1));
		} catch (FileNotFoundException e) {
			// Dann nicht...
		}
		try {
			for (String plain : this.dictionary.keySet()) {
				String expected = this.dictionary.get(plain);
				String hash = this.calc.calculatePwdHash(plain);
				this.dictionary.put(plain, hash);
				String logtext = plain + " --> " + hash + " (" + expected + ")";
				System.out.println(logtext);
				Assertions.assertEquals(expected.toUpperCase(), hash.toUpperCase());
				if (outputUTF8 != null) {
					try {
						outputUTF8.write(logtext + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (outputANSI != null) {
					try {
						outputANSI.write(logtext + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} finally {
			try {
				outputUTF8.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				outputANSI.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

