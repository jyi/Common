package util;

public class _Debug {

	public static interface Message {
		String message();

		String sort();
	}

	public static void println(boolean on, Message msg) {
		if (on) {
			StringBuffer sb = new StringBuffer();
			sb.append("[");
			sb.append(msg.sort());
			sb.append("]: ");
			sb.append(msg.message());
			System.err.println(sb.toString());
			System.err.flush();
		}
	}

	public static void println(String s, boolean on) {
		if (on) {
			System.err.println(s);
		}
	}
}
