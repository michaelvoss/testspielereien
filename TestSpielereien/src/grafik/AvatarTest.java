package grafik;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AvatarTest {

	@Test
	void testGenerateFile() {
		SimpleAvatarGenerator a = new SimpleAvatarGenerator("MV", 80, 30);
		try {
			ByteArrayOutputStream out = a.getByteArrayOutputsStream();
			
			OutputStream outputStream = new FileOutputStream("C:\\temp\\avatar.png");
			out.writeTo(outputStream);
			
			outputStream.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			Assertions.fail(e.getMessage());
			
		}
	}
	
}
