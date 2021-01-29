package casting;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Aufrufer {
	@Test
	public void test1() {
		Factory f = new Factory();
		Set<Unterbereich> gefunden = f.alle();
		Set<Werthilfe> alle = new HashSet<Werthilfe>();
		Set<? extends Werthilfe> gecastet = gefunden;
		for (Unterbereich u : gefunden) {
			alle.add(u);
		}
		Assertions.assertEquals(2, alle.size());
	}
}
