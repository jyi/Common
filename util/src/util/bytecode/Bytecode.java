package util.bytecode;

public class Bytecode {

	public static boolean isInit(String name) {
		return name.startsWith("<init>");
	}
	
	public static boolean isClinit(String name) {
		return name.startsWith("<clinit>");
	}

}
