package text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SplitSpiel {

	private String test1 = "2019-01-01~2019-10-10";
	private String test2 = "~2019-10-10";
	private String test3 = "2019-01-01~";
	private String test4 = "2019-01-01";

	@Test
	public void split1() {
		System.out.println(this.test1);
		String[] a = this.test1.split("~");

		for (int i = 0; i < a.length; i++) {
			System.out.println("" + i + " -> " + a[i]);
		}

		Assertions.assertEquals(2, a.length);
	}

	@Test
	public void split2() {
		System.out.println(this.test2);
		String[] a = this.test2.split("~");

		for (int i = 0; i < a.length; i++) {
			System.out.println("" + i + " -> " + a[i]);
		}

		Assertions.assertEquals(2, a.length);
		Assertions.assertEquals("", a[0]);
	}

	@Test
	public void split3() {
		System.out.println(this.test3);
		String[] a = this.test3.split("~");

		for (int i = 0; i < a.length; i++) {
			System.out.println("" + i + " -> " + a[i]);
		}

		Assertions.assertEquals(1, a.length);
	}

	@Test
	public void split4() {
		System.out.println(this.test4);
		String[] a = this.test4.split("~");

		for (int i = 0; i < a.length; i++) {
			System.out.println("" + i + " -> " + a[i]);
		}

		Assertions.assertEquals(1, a.length);
	}
}
