package groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroovyTest {

	@Test
	public void dateTest() {
		Binding binding = new Binding();
		GroovyShell shell = new GroovyShell(binding);

		String groovyCode = "new Date()";

		Object value = shell.evaluate(groovyCode);
		System.out.println(value.getClass().getName() + " - " + value);

		Assertions.assertTrue(value.getClass().equals(java.util.Date.class));

		String sValue = String.valueOf(value);
		System.out.println(sValue);
	}

	@Test
	public void integerTest() {
		Binding binding = new Binding();
		GroovyShell shell = new GroovyShell(binding);

		String groovyCode = "14 + 32";

		Object value = shell.evaluate(groovyCode);
		System.out.println(value.getClass().getName() + " - " + value);

		Assertions.assertTrue(value.getClass().equals(java.lang.Integer.class));

		String sValue = String.valueOf(value);
		System.out.println(sValue);
	}

	@Test
	public void booleanTest() {
		Binding binding = new Binding();
		GroovyShell shell = new GroovyShell(binding);

		String groovyCode = "14 + 32 == 46";

		Object value = shell.evaluate(groovyCode);
		System.out.println(value.getClass().getName() + " - " + value);

		Assertions.assertTrue(value.getClass().equals(java.lang.Boolean.class));

		String sValue = String.valueOf(value);
		System.out.println(sValue);
	}
}
