package casting;

public class Unterbereich implements Werthilfe {
	private String nummer = "42";
	
	public Unterbereich(int nummer) {
		this.nummer = String.valueOf(nummer);
	}
	
	@Override
	public String sayHello() {
		return "Ich bin's, die " + this.nummer + "!";
	}

}
