package util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Procedure extends AccessibleObject {

	private final boolean isConstructor;
	private final boolean isMethod;

	private final AccessibleObject proc;

	public Procedure(Constructor<?> constructor) {
		this.isConstructor = true;
		this.isMethod = false;
		this.proc = constructor;
	}

	public Procedure(Method method) {
		this.isConstructor = false;
		this.isMethod = true;
		this.proc = method;
	}

	public Constructor<?> constructor() {
		assert proc instanceof Constructor<?>;
		return (Constructor<?>) proc;
	}

	public Class<?> getDeclaringClass() {
		if (isMethod) {
			Method m = method();
			return m.getDeclaringClass();
		} else {
			Constructor<?> c = constructor();
			return c.getDeclaringClass();
		}
	}

	public void invoke(Object rcv, Object... args)
			throws IllegalArgumentException, IllegalAccessException,
			InstantiationException {
		try {
			if (isMethod) {
				Method m = method();
				m.invoke(rcv, args);
			} else {
				Constructor<?> c = constructor();
				c.newInstance(args);
			}
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Error();
		}

	}

	public boolean isConstructor() {
		return this.isConstructor;
	}

	public boolean isMethod() {
		return this.isMethod;
	}

	public boolean isVoid() {
		if (isMethod) {
			Method m = method();
			Class<?> retTyp = m.getReturnType();
			return _Class.isTheSame(retTyp, void.class);
		} else {
			return true;
		}
	}

	public Method method() {
		assert proc instanceof Method;
		return (Method) proc;
	}

	public String toSimpleString() {
		if (isMethod()) {
			Method m = (Method) proc;
			Class<?> c = m.getDeclaringClass();
			return c.getSimpleName() + "." + m.getName();
		} else {
			return ((Constructor<?>) proc).getName() + ".<init>";
		}
	}

	@Override
	public String toString() {
		return proc.toString();
	}

}
