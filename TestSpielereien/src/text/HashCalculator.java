package text;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashCalculator {

	private static final String HashingAlgorithm = "MD5";
	private static HashCalculator singletonInstance = null;
	private static MessageDigest md5Digest = null;

	private HashCalculator() {

	}

	/**
	 * Liefert die einzige Instanz dieser Klasse zurück
	 * 
	 * @return Singleton-Instanz dieser Klasse
	 */
	public static HashCalculator getInstance() {
		if (HashCalculator.singletonInstance == null) {
			HashCalculator.singletonInstance = new HashCalculator();
		}

		return HashCalculator.singletonInstance;
	}

	/**
	 * Errechnet einen Hash zum angegebenen plain text
	 * 
	 * @param  plainText String, der gehashed werden soll
	 * @return           MD5-Hash zum Input
	 */
	public String calculatePwdHash(String plainText) {
		if (plainText == null || plainText.isEmpty()) {
			return null;
		}

		if (HashCalculator.md5Digest == null) {
			try {
				HashCalculator.md5Digest = MessageDigest.getInstance(HashCalculator.HashingAlgorithm);
			} catch (NoSuchAlgorithmException e) {
				return "";
			}
		}

		byte[] hashy = HashCalculator.md5Digest.digest(plainText.getBytes(StandardCharsets.UTF_8));

		StringBuilder hashBuilder = new StringBuilder();

		for (int i = 0; i < hashy.length; i++) {
			if ((0xff & hashy[i]) < 0x10) {
				hashBuilder.append("0" + Integer.toHexString((0xFF & hashy[i])));
			} else {
				hashBuilder.append(Integer.toHexString(0xFF & hashy[i]));
			}
		}

		return hashBuilder.toString();
	}
}
