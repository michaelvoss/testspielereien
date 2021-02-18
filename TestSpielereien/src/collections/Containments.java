package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Containments {

	public Containments() {
		// TODO Auto-generated constructor stub
	}
	
	public void listContains() {
		Object something = null;
		List<Integer> list = new ArrayList<Integer>();
		something = list.get(list.indexOf(something));
	}
	
	public void setContains() {
		Object something = null;
		Set<Integer> set = new HashSet<Integer>();
	}

}
