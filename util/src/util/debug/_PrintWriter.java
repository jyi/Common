package util.debug;

import java.io.PrintWriter;

public class _PrintWriter extends PrintWriter {
	
	private PrintWriter pw;

	public _PrintWriter(PrintWriter pw) {
		super(pw);
		this.pw = pw;
	}
	
	public void print(String s) {
		pw.print(s);
	}
	
}
