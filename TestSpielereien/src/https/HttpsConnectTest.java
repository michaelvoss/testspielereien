package https;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;

import org.junit.jupiter.api.Test;

public class HttpsConnectTest {

	private String targetUrlTest = "https://verbundsystem-t/documentgateway/rest/status";
	private String targetUrlQs = "https://verbundsystem-q/documentgateway/rest/status";
	private String username = "z999990";
	private String password = "0987-yxcv!anlei/weblogic";
	private String jsonString = "";

	@Test
	public void testTest() throws Exception {
		this.createConnection(this.targetUrlTest);
	}
	
	@Test
	public void testQs() throws Exception {
		this.createConnection(this.targetUrlQs);
	}
	
	public void createConnection(String urlInput) throws Exception {
		System.out.println(System.getProperty("java.version"));
		System.out.println("Verbinde mit " + urlInput);

		String phrase = this.username + ":" + this.password;
		String authorizationString = "Basic " + Base64.getEncoder().encodeToString(phrase.getBytes());

		try {
			URL url = new URL(urlInput);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", authorizationString);
			conn.setRequestProperty("User-Agent","GruSiDialog");
			conn.setRequestProperty("Accept","*/*");
			conn.setRequestProperty("Accept-Encoding","gzip, deflate, br");		
			conn.setRequestProperty("Content-Length", String.valueOf(this.jsonString.length()));
			conn.setRequestProperty("Expect","100-continue");
			conn.setRequestProperty("Content-Type", "application/json");
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
