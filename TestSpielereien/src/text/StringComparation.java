package text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringComparation {

	private String compVal = "50678";

	@Test
	void test1() {
		String von = "50667";
		String bis = "50999";
		System.out.println(von + ".." + bis);

		boolean isKleiner = von.compareTo(this.compVal) <= 0;
		boolean isGroesser = bis.compareTo(this.compVal) >= 0;

		System.out.println(von + " <= " + this.compVal + ": " + isKleiner);
		System.out.println(this.compVal + " <= " + bis + ": " + isGroesser);

		Assertions.assertTrue(isKleiner, von + " ist nicht kleiner als " + this.compVal);
		Assertions.assertTrue(isGroesser, bis + " ist nicht größer als " + this.compVal);
	}

	@Test
	void test2() {
		String von = "00001";
		String bis = "99999";
		System.out.println(von + ".." + bis);

		boolean isKleiner = von.compareTo(this.compVal) <= 0;
		boolean isGroesser = bis.compareTo(this.compVal) >= 0;

		System.out.println(von + " <= " + this.compVal + ": " + isKleiner);
		System.out.println(this.compVal + " <= " + bis + ": " + isGroesser);

		Assertions.assertTrue(isKleiner, von + " ist nicht kleiner als " + this.compVal);
		Assertions.assertTrue(isGroesser, bis + " ist nicht größer als " + this.compVal);
	}

	@Test
	void test3() {
		String von = "1";
		String bis = "99999";
		System.out.println(von + ".." + bis);

		boolean isKleiner = von.compareTo(this.compVal) <= 0;
		boolean isGroesser = bis.compareTo(this.compVal) >= 0;

		System.out.println(von + " <= " + this.compVal + ": " + isKleiner);
		System.out.println(this.compVal + " <= " + bis + ": " + isGroesser);

		Assertions.assertTrue(isKleiner, von + " ist nicht kleiner als " + this.compVal);
		Assertions.assertTrue(isGroesser, bis + " ist nicht größer als " + this.compVal);
	}

	@Test
	void test4() {
		String von = "6";
		String bis = "99999";
		System.out.println(von + ".." + bis);

		boolean isKleiner = von.compareTo(this.compVal) <= 0;
		boolean isGroesser = bis.compareTo(this.compVal) >= 0;

		System.out.println(von + " <= " + this.compVal + ": " + isKleiner);
		System.out.println(this.compVal + " <= " + bis + ": " + isGroesser);

		Assertions.assertFalse(isKleiner, von + " ist kleiner als " + this.compVal);
		Assertions.assertTrue(isGroesser, bis + " ist nicht größer als " + this.compVal);
	}

	@Test
	void test5() {
		String von = "00006";
		String bis = "99999";
		System.out.println(von + ".." + bis);

		boolean isKleiner = von.compareTo(this.compVal) <= 0;
		boolean isGroesser = bis.compareTo(this.compVal) >= 0;

		System.out.println(von + " <= " + this.compVal + ": " + isKleiner);
		System.out.println(this.compVal + " <= " + bis + ": " + isGroesser);

		Assertions.assertTrue(isKleiner, von + " ist nicht kleiner als " + this.compVal);
		Assertions.assertTrue(isGroesser, bis + " ist nicht größer als " + this.compVal);
	}
}
