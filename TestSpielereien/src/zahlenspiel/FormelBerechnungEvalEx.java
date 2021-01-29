package zahlenspiel;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.udojava.evalex.Expression;

public class FormelBerechnungEvalEx {

	@Test
	public void exp4jTest() {
		// String formel = "3 * sin(y) - 2 / (x - 2)";
		String formel = "(330 + (0.75 * x) - (1.3 * y)) * 0.332";
		String xString = "303.41";
		String yString = "3.14";
		
		Expression e = new Expression(formel)
				.setPrecision(30)
		        .setVariable("x", new BigDecimal(xString))
		        .setVariable("y", new BigDecimal(yString));
		BigDecimal result = e.eval();
		System.out.println("f(x, y) = " + formel);
		System.out.println("f(303.41, 3.14) = " + result);
		Assertions.assertEquals(new BigDecimal("183.753866"), result);
	}
}
