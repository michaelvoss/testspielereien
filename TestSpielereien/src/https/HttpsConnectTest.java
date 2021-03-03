package https;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;

import org.junit.jupiter.api.Test;

public class HttpsConnectTest {

	private static final String CONTEXT_TYPE = "application/json";
	//private static final String CONTEXT_TYPE = "text/plain";
	private static final String ACCEPTED_ENCODINGS = "gzip, deflate, br";
	private static final String REQUEST_TYPE = "GET";
	// private static final String REQUEST_TYPE = "POST";
	private String targetUrlTest = "https://verbundsystem-t/documentgateway/rest/status";
	private String targetUrlQs = "https://verbundsystem-q/documentgateway/rest/status";
	private String username = "z999990";
	private String password = "0987-yxcv!anlei/weblogic";
	private String jsonString = "";

	private String fehlerAntwort = "";

	@Test
	public void testTest() throws Exception {
		this.createConnection(this.targetUrlTest);
	}

	@Test
	public void testQs() throws Exception {
		this.createConnection(this.targetUrlQs);
	}

	@Test
	public void testSimpleTest() throws Exception {
		this.createSimpleConnection(this.targetUrlTest);
	}

	@Test
	public void testSimpleQs() throws Exception {
		this.createSimpleConnection(this.targetUrlQs);
	}

	private void createConnection(String urlInput) throws Exception {
		System.out.println("=========== TEST ===========");
		System.out.println("JRE-Version " + System.getProperty("java.version"));
		System.out.println("Verbinde mit " + urlInput);

		String phrase = this.username + ":" + this.password;
		String authorizationString = "Basic " + Base64.getEncoder().encodeToString(phrase.getBytes());

		try {
			URL url = new URL(urlInput);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

			conn.setRequestMethod(HttpsConnectTest.REQUEST_TYPE);
			conn.setRequestProperty("Authorization", authorizationString);
			conn.setRequestProperty("User-Agent","GruSiDialog");
			conn.setRequestProperty("Accept","*/*");
			conn.setRequestProperty("Accept-Encoding",HttpsConnectTest.ACCEPTED_ENCODINGS);		
			conn.setRequestProperty("Content-Length", String.valueOf(this.jsonString.length()));
			conn.setRequestProperty("Expect","100-continue");
			conn.setRequestProperty("Content-Type", HttpsConnectTest.CONTEXT_TYPE);
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.setDoOutput(true);

			System.out.println("Starte Verbindungsaufbau");
			conn.connect();
			System.out.println("Verbindung aufgebaut");

			//			System.out.println("Schreibe Payload");
			//			OutputStream os = conn.getOutputStream();
			//			os.write(this.jsonString.getBytes());
			//			os.flush();
			//			os.close();
			//			System.out.println("Daten geschrieben");

			System.out.println("Lese Response des Services (" + conn.getResponseCode() + ")");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {	
				String text = "Fehler beim Erzeugen der http:-Verbindung zu " + urlInput + " (HTTP Code " + conn.getResponseCode() + ")";
				System.out.println(text + " - JSON-String ist\n" + this.jsonString);

				try {
					this.receiveResponse(conn, urlInput);
					text = this.fehlerAntwort;
				} catch (SocketTimeoutException s) {
					String message = "Timeout beim Lesen von " + urlInput + " (5000 ms)";
					System.out.println(message);
					s.printStackTrace(System.err);
					throw new Exception(message, s);										
				} catch (IOException e) {
					String message = "Fehler beim Lesen der Antwort von " + urlInput + " (" + this.fehlerAntwort + ")";
					System.out.println(message);
					throw new Exception(message, e);
				}

				String exMessage = "Fehler bei der Kommunikation. An " + urlInput + " gesendeter Request:\n" + this.jsonString + "\nResponse:\n" + this.fehlerAntwort;
				throw new Exception(exMessage);
			} else {
				System.out.println("http-Response: " + HttpURLConnection.HTTP_OK);
			}
		} catch (IOException e) {
			System.err.println("Error creating HTTP connection");
			e.printStackTrace();
			throw e;
		}
	}

	private void receiveResponse(HttpURLConnection conn, String url) throws IOException {
		System.out.println("Lese Response des Services");
		this.fehlerAntwort = "";

		BufferedReader br;
		br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String response;
		while ((response = br.readLine()) != null) {
			this.fehlerAntwort = this.fehlerAntwort + "\n" + response;
		}
		br.close();

		System.out.println("Response von " + url + ":\n" + this.fehlerAntwort);
	}

	private void createSimpleConnection(String urlInput) throws IOException {
		System.out.println("=========== SIMPLE TEST ===========");
		System.out.println("JRE-Version " + System.getProperty("java.version"));
		System.out.println("Verbinde mit " + urlInput);		



		String phrase = this.username + ":" + this.password;
		String authorizationString = "Basic " + Base64.getEncoder().encodeToString(phrase.getBytes());

		try {
			URL url = new URL(urlInput);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

			conn.setRequestMethod(HttpsConnectTest.REQUEST_TYPE);
			conn.setRequestProperty("Authorization", authorizationString);
			conn.setRequestProperty("User-Agent","GruSiDialog");
			conn.setRequestProperty("Accept","*/*");
			conn.setRequestProperty("Accept-Encoding",HttpsConnectTest.ACCEPTED_ENCODINGS);		
			conn.setRequestProperty("Content-Length", String.valueOf(this.jsonString.length()));
			conn.setRequestProperty("Expect","100-continue");
			conn.setRequestProperty("Content-Type", HttpsConnectTest.CONTEXT_TYPE);
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);

			System.out.println("Starte Verbindungsaufbau");
			conn.connect();
			System.out.println("Verbindung aufgebaut");
			System.out.println("Response " + conn.getResponseCode());

			OutputStream os = conn.getOutputStream();
			os.write(this.jsonString.getBytes());
			os.flush();
			os.close();

			System.out.println("Lese Response des Services");
			String fehlerAntwort = "";

			BufferedReader br;
			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String response;
			while ((response = br.readLine()) != null) {
				fehlerAntwort = fehlerAntwort + "\n" + response;
			}
			br.close();

			System.out.println("Response von " + urlInput + ":\n" + fehlerAntwort);

		} catch (IOException e) {
			System.err.println("Error creating HTTP connection");
			e.printStackTrace();
			throw e;
		}
	}

}
