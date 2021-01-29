package zahlenspiel;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class TestRounding {
	
	@Test
	public void test1() {
		String[] values = {"0.254", "0.255", "0.256"};
		
		for (String bds : values) {
			BigDecimal bd = new BigDecimal(bds);
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			System.out.println(bds + " --> " + bd);
		}
	}
	
	@Test
	public void test2() {
		String[] values = {"0.254", "0.255", "0.256"};
		
		for (String bds : values) {
			BigDecimal bd = new BigDecimal(bds);
			bd = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			System.out.println(bds + " ---> " + bd);
		}
	}

	@Test
	public void test3() {
		String[] values = {"13.62", "13.63", "13.64"};
		BigDecimal mult = new BigDecimal("42");
		
		for (String bds : values) {
			BigDecimal bd = new BigDecimal(bds);
			bd = bd.multiply(mult).divide(new BigDecimal("100"));
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			System.out.println(bds + " * " + mult + " / 100 --> " + bd);
		}
	}
	
	@Test
	public void test4() {
		String[] values = {"13.62", "13.63", "13.64"};
		BigDecimal mult = new BigDecimal("0.42");
		
		for (String bds : values) {
			BigDecimal bd = new BigDecimal(bds);
			bd = bd.multiply(mult);
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			System.out.println(bds + " * " + mult + " --> " + bd);
		}
	}
}
