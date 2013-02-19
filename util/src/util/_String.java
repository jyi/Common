package util;

import java.util.List;

/**
 * Utilities for String.
 * 
 * @author Jooyong Yi
 */
public class _String {

	public static String[] add(final String[] /* nullable */array,
			final String newElem) {
		final int arrayLen = (array == null) ? 0 : array.length;
		final String[] newArray = new String[arrayLen + 1];
		System.arraycopy(array, 0, newArray, 0, arrayLen);
		newArray[arrayLen] = newElem;
		return newArray;
	}

	public static String getLast(final String src, final String sep) {
		String[] coms = src.split(toRegular(sep));
		return coms[coms.length - 1];
	}

	/**
	 * Splits the src string with the sep separator, and replaces the last
	 * component with the sub string.
	 * 
	 * @param src
	 * @param sep
	 * @param sub
	 * @return
	 */
	public static String replaceLast(final String src, final String sep,
			final String sub) {
		String[] coms = src.split(toRegular(sep));
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < coms.length; i++) {
			if (i < coms.length - 1) {
				sb.append(coms[i]);
				sb.append(sep);
			} else {
				sb.append(sub);
			}
		}

		return sb.toString();
	}

	public static String toRegular(final String s) {
		if (s.equals(".")) {
			return "\\.";
		} else {
			return s;
		}
	}

	public static String insertBetween(String[] strs, String insert) {
		assert strs.length >= 2;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			sb.append(strs[i]);
			sb.append(insert);
		}
		sb.delete(sb.length() - insert.length(), sb.length());
		return sb.toString();
	}
	
	public static String insertBetween(List<String> strs, String insert) {
		assert strs.size() >= 2;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs.size(); i++) {
			sb.append(strs.get(i));
			sb.append(insert);
		}
		sb.delete(sb.length() - insert.length(), sb.length());
		return sb.toString();
	}
	
	public static String toString(String[] arr) {
		StringBuilder sb = new StringBuilder();
		for (String s : arr) {
			sb.append(s);
			sb.append(" ");
		}
		return sb.toString();
	}

}
