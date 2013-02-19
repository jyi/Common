package util.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class _List {

	public static <L extends List<T>, T, U extends T> List<T> cons(L lst,
			U... args) {
		for (T arg : args) {
			lst.add(arg);
		}
		return lst;
	}

	public static <T, U extends T> List<T> cons(U... args) {
		java.util.List<T> result = new ArrayList<T>();
		for (T arg : args) {
			result.add(arg);
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	public static java.util.List emptyList() {
		return new java.util.ArrayList(0);
	}

	public static <T> List<T> list(Collection<T> c) {
		java.util.List<T> result = new ArrayList<T>(c.size());
		result.addAll(c);
		return result;
	}

	public static String toStr(List<?> list, String del) {
		StringBuilder sb = new StringBuilder();
		for (Object elem : list) {
			sb.append(elem);
			sb.append(del);
		}
		if (list.size() > 0) {
			sb.delete(sb.length() - del.length(), sb.length());
		}
		return sb.toString();
	}

	public static <T> List<T> union(List<T> list1, List<T> list2) {
		List<T> result = new ArrayList<T>(list1.size() + list2.size());
		for (T e : list1) {
			result.add(e);
		}
		for (T e : list2) {
			result.add(e);
		}
		return result;
	}
}
