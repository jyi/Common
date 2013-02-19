package util.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class _Reader {

	public static String readLines(BufferedReader br) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line = null;
		do {
			line = br.readLine();
			if (line != null) {
				sb.append(line);
				sb.append("\n");
			}
		} while (line != null);
		return sb.toString();
	}

	public static String readLines(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		return readLines(br);
	}
}
