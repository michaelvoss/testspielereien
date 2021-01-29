package json;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParsing {

	private String test1 = "";
	private String test2 = "{\"token_type\":\"bearer\",\"access_token\":\"AAAA%2FAAA%3DAAAAAAAA\",\"scope\": \"scope of the token\",\"expires_in\": 200,\"refresh_token\":\"fdb8fdbecf1d03ce5e6125c067733c0d51de209c\"}";
	private String test3 = "[ \"Ford\", \"BMW\", \"Fiat\" ]\n";
	private String test4 = "Lachmal";
	private String test5 = "{ key: value }";
	private String test6 = "";

	@Test
	public void test1() {
		System.out.println(this.test1);
		Assertions.assertTrue(this.isValidJson(this.test1));
	}

	@Test
	public void test2() {
		Assertions.assertTrue(this.isValidJson(this.test2));
	}

	@Test
	public void test3() {
		Assertions.assertTrue(this.isValidJson(this.test3));
	}

	@Test
	public void test4() {
		Assertions.assertFalse(this.isValidJson(this.test4));
	}

	@Test
	public void test5() {
		Assertions.assertFalse(this.isValidJson(this.test5));
	}

	@Test
	public void test6() {
		Assertions.assertTrue(this.isValidJson(this.test6));
	}

	private boolean isValidJson(String text) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.readTree(text);
			return true;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

}
