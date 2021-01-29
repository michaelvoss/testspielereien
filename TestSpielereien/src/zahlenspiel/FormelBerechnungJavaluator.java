package zahlenspiel;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.StaticVariableSet;

/**
 * testklasse für javaluator
 * Kannn nicht mit BigDecimal etc. umgehen, Darstellungsfehler bei Double
 * Kommt daher nicht infrage!
 * 
 * @author Z133111
 *
 */
public class FormelBerechnungJavaluator {

	@Test
	public void javaluatorTest() {
		// String formel = "3 * sin(y) - 2 / (x - 2)";
		String formel = "(330 + (0.75 * x) - (1.3 * y)) * 0.332";
		String xString = "303.41";
		String yString = "3.14";
		
		DoubleEvaluator e = new DoubleEvaluator();
		StaticVariableSet<Double> vars = new StaticVariableSet<Double>();
		vars.set("x", new Double(xString));
		vars.set("y", new Double(yString));
		Double result = e.evaluate(formel, vars);
		System.out.println("f(x, y) = " + formel);
		System.out.println("f(303.41, 3.14) = " + result);
		Assertions.assertEquals(183.753866, result.doubleValue());
	}
}
