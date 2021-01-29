package casting;

import java.util.HashSet;
import java.util.Set;

public class Factory {
	public Set<Unterbereich> alle() {
		Set<Unterbereich> neu = new HashSet<Unterbereich>();
		neu.add(new Unterbereich(1));
		neu.add(new Unterbereich(2));
		
		return neu;
	}
}
