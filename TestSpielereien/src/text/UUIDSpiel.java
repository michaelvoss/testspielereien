package text;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class UUIDSpiel {
	@Test
	public void showUUID() {
		UUID uuid = UUID.randomUUID();
		String orig = uuid.toString();
		String replaced = orig.replaceAll("-", "");
		System.out.println(orig + " --> " + replaced);
	}

}
