package https;

public class ConnectionTestStarter {

	public ConnectionTestStarter() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		HttpsConnectTest test = new HttpsConnectTest();
		System.out.println("Start der Tests");
		try {
			test.testTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			test.testQs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Tests abgeschlossen");
	}

}
