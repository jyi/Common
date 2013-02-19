/**
 * This is used to exclude designated methods from being transformed.
 */
package util.data.serial;

import java.util.ArrayList;
import java.util.List;

public class ClassInfo {

	private final String name;
	private final List<MethodInfo> methods = new ArrayList<MethodInfo>();

	public ClassInfo(String name) {
		if (name.charAt(0) == '[')
			throw new RuntimeException(
					"Attempt to make a class whose name starts with [");
		this.name = name;
	}

	public String name() {
		return this.name;
	}

	public void addMethod(MethodInfo m) {
		methods.add(m);
	}
	
	public List<MethodInfo> methods() {
		return this.methods;
	}

}
