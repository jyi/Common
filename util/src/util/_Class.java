package util;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import util._Debug.Message;
import util.bytecode.Bytecode;

/**
 * 
 * @author Jooyong Yi
 */
public class _Class {

	@SuppressWarnings("serial")
	static class NotFoundException extends Exception {
	}

	public final static String SEP = ".";

	public static Class<?> box(Class<?> cls) {
		if (int.class.equals(cls)) {
			return Integer.class;
		}
		if (boolean.class.equals(cls)) {
			return Boolean.class;
		}
		if (short.class.equals(cls)) {
			return Short.class;
		}
		if (long.class.equals(cls)) {
			return Long.class;
		}
		if (char.class.equals(cls)) {
			return Character.class;
		}
		if (byte.class.equals(cls)) {
			return Byte.class;
		}
		if (double.class.equals(cls)) {
			return Double.class;
		}
		if (float.class.equals(cls)) {
			return Float.class;
		}
		return cls;
	}

	public static Constructor<?> constructor(Class<?> cls,
			Class<?>[] actualArgTypes) {
		Class<?> curCls = cls;
		while (curCls != null) {
			try {
				return _Class.declaredConstructor(curCls, actualArgTypes);
			} catch (NotFoundException e) {
				curCls = curCls.getSuperclass();
			}
		}

		throw new Error();
	}

	public static Constructor<?> declaredConstructor(Class<?> decType,
			Class<?>[] actualArgTypes) throws NotFoundException {
		Constructor<?>[] conses = decType.getConstructors();
		for (final Constructor<?> cons : conses) {
			_Debug.println(false, new Message() {

				public String message() {
					return cons.toString();
				}

				public String sort() {
					return "constructor search";
				}
			});
			if (cons.getName().equals(decType.getName())
					&& util._Class.match(cons.getParameterTypes(),
							actualArgTypes)) {
				return cons;
			}
		}

		throw new NotFoundException();
	}

	public static Method declaredMethod(Class<?> decType, String name,
			Class<?>[] actualArgTypes) throws NotFoundException {
		Method[] mthds = decType.getDeclaredMethods();
		for (final Method mthd : mthds) {
			_Debug.println(false, new Message() {

				public String message() {
					// TODO Auto-generated method stub
					return mthd.toString();
				}

				public String sort() {
					// TODO Auto-generated method stub
					return "method search";
				}
			});
			if (mthd.getName().equals(name)
					&& util._Class.match(mthd.getParameterTypes(),
							actualArgTypes)) {
				return mthd;
			}
		}

		throw new NotFoundException();
	}

	/**
	 * 
	 * @param c1
	 * @param c2
	 * @return true if c1 is a subtype of c2.
	 */
	public static boolean isSubtype(Class<?> c1, Class<?> c2) {
		return c2.isAssignableFrom(c1);
	}

	public static boolean isTheSame(Class<?> c1, Class<?> c2) {
		return c1.isAssignableFrom(c2) && c2.isAssignableFrom(c1);
	}

	public static boolean match(Class<?>[] formalTypes, Class<?>[] actualTypes) {
		if (formalTypes.length != actualTypes.length) {
			return false;
		}

		for (int i = 0; i < formalTypes.length; i++) {
			if (!isSubtype(box(actualTypes[i]), box(formalTypes[i]))) {
				return false;
			}
		}
		return true;
	}

	public static Method method(Class<?> cls, String name,
			Class<?>[] actualArgTypes) {
		Class<?> curCls = cls;
		while (curCls != null) {
			try {
				return _Class.declaredMethod(curCls, name, actualArgTypes);
			} catch (NotFoundException e) {
				curCls = curCls.getSuperclass();
			}
		}

		throw new Error();
	}

	public static Procedure procedure(Class<?> cls, String name,
			Class<?>[] actualArgTypes) {
		if (Bytecode.isInit(name)) {
			return new Procedure(_Class.constructor(cls, actualArgTypes));
		} else {
			return new Procedure(_Class.method(cls, name, actualArgTypes));
		}
	}

	public static void setStaticField(Class<?> decType, String name, Object val)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		Field f = staticField(decType, name);
		f.set(null, val);
	}

	public static Field staticField(Class<?> cls, String name)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		Field f = cls.getField(name);
		return f;
	}

	@SuppressWarnings("unchecked")
	public static <T> T staticFieldVal(Class<?> cls, Class<T> fieldType,
			String name) {
		try {
			Field f = cls.getField(name);
			return (T) f.get(null);
		} catch (NoSuchFieldException e) {
			throw new Error("No field " + name + " in " + cls.getName());
		} catch (Exception e) {
			throw new Error(e);
		}
	}

	public static Class<?> toArray(Class<?> c) {
		return Array.newInstance(c, 0).getClass();
	}

	public static Class<?> unbox(Class<?> cls) {
		if (Integer.class.equals(cls)) {
			return int.class;
		}
		if (Boolean.class.equals(cls)) {
			return boolean.class;
		}
		if (Short.class.equals(cls)) {
			return short.class;
		}
		if (Long.class.equals(cls)) {
			return long.class;
		}
		if (Character.class.equals(cls)) {
			return char.class;
		}
		if (Byte.class.equals(cls)) {
			return byte.class;
		}
		if (Double.class.equals(cls)) {
			return double.class;
		}
		if (Float.class.equals(cls)) {
			return float.class;
		}
		return cls;
	}

	public static Field field(Class<? extends Object> c, String fName)
			throws NoSuchFieldException {
		try {
			Field f = c.getDeclaredField(fName);
			assert f != null;
			return f;
		} catch (NoSuchFieldException e) {
			Class<?>[] interfaces = c.getInterfaces();
			for (Class<?> inter : interfaces) {
				return field(inter, fName);
			}
			Class<?> sc = c.getSuperclass();
			if (sc != null) {
				return field(sc, fName);
			} else {
				throw new NoSuchFieldException();
			}
		} catch (SecurityException e) {
			throw new Error(e);
		}
	}

	public static Object fieldVal(Object rcv, String fName)
			throws NoSuchFieldException {
		Class<? extends Object> c = rcv.getClass();
		Field f = _Class.field(c, fName);
		f.setAccessible(true);
		try {
			return f.get(rcv);
		} catch (IllegalArgumentException e) {
			throw new Error(e);
		} catch (IllegalAccessException e) {
			throw new Error(e);
		}
	}

	public static String internalName(Class<?> c) {
		return c.getName().replace('.', '/');
	}

	public static String getSimpleName(String className, String sep) {
		return _String.getLast(className, sep);
	}

	public static InputStream inputStream(Class<?> clz) {
		String className = _Class.internalName(clz) + ".class";
		InputStream rst = clz.getClassLoader().getResourceAsStream(className);
		return rst;
	}
	
	public static Class<?> groundType(Class<?> c) {
		if (c.isArray()) {
			return groundType(c.getComponentType());
		} else {
			return c;
		}
	}

}
