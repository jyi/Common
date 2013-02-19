package util.data;

import java.util.HashSet;

public class _Set {

	public static <T> java.util.Set<T> clone(java.util.Set<T> s) {
		java.util.Set<T> clone = new HashSet<T>();
		for (T elem : s) {
			clone.add(elem);
		}
		return clone;
	}

	public static <T> java.util.Set<T> diff(java.util.Set<T> s1,
			java.util.Set<T> s2) {
		java.util.Set<T> s1_clone = _Set.clone(s1);
		s1_clone.removeAll(s2);
		return s1_clone;
	}
}
