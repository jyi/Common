/**
 * This is used to exclude designated methods from being transformed.
 */
package util.data.serial;

public class MethodInfo {

	private final String name;
	private final String[] paramTypes;
	private final String returnType;

	public MethodInfo(String name, String[] paramTypes, String returnType) {
		this.name = name;
		this.paramTypes = paramTypes;
		this.returnType = returnType;
	}

	public MethodInfo(String name, String returnType) {
		this.name = name;
		this.paramTypes = new String[] {};
		this.returnType = returnType;
	}

	public String name() {
		return name;
	}

	public String[] paramTypes() {
		return paramTypes;
	}

	public String returnType() {
		return returnType;
	}

}
