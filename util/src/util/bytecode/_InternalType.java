package util.bytecode;

public class _InternalType {

	public static String convert(String javaType) {
		if (javaType.equals("byte"))
			return "B";
		if (javaType.equals("char"))
			return "C";
		if (javaType.equals("double"))
			return "D";
		if (javaType.equals("float"))
			return "F";
		if (javaType.equals("int"))
			return "I";
		if (javaType.equals("long"))
			return "J";
		if (javaType.equals("short"))
			return "S";
		if (javaType.equals("boolean"))
			return "Z";

		throw new Error();
	}

}
