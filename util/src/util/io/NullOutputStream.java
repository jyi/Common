package util.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * @author Jooyong Yi (jooyong@comp.nus.edu.sg)
 * @date May 3, 2012
 */
public class NullOutputStream extends OutputStream {

	@Override
	public void write(int b) throws IOException {
	}

	@Override
	public void write(byte b[]) throws IOException {
	}

	@Override
	public void write(byte b[], int off, int len) throws IOException {
	}

}
