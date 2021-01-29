package zahlenspiel;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * Test Exp4j.
 * Kann nicht mit BigDecimals etc. umgehen, Darstellungsfehler bei double etc.,
 * kommt daher nicht in Frage
 * @author Z133111
 *
 */

public class FormelBerechnungExp4j {

	@Test
	public void exp4jTest() {
		// String formel = "3 * sin(y) - 2 / (x - 2)";
		String formel = "(330 + (0.75 * x) - (1.3 * y)) * 0.332";
		
		Expression e = new ExpressionBuilder(formel)
		        .variables("x", "y")
		        .build()
// Mittel der Wahl wäre BigDecimal, Exp4j kann das aber nicht!		        
//		        .setVariable("x", new BigDecimal("303.41"))
		        .setVariable("x", 303.41)
		        .setVariable("y", 3.14);
		double result = e.evaluate();
		System.out.println("f(x, y) = " + formel);
		System.out.println("f(303.41, 3.14) = " + result);
		// Ungenauigkeiten wegen double!!!
		Assertions.assertEquals(183.753866, result);
	}
}
