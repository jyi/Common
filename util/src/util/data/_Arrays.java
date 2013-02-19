package util.data;

import java.util.Arrays;

/**
 * 
 * @author Jooyong Yi (jooyong@comp.nus.edu.sg)
 * @date May 9, 2012
 */
public class _Arrays<T> {

	public T[] concat(T[] a1, T[] a2) {
		T[] a3 = Arrays.copyOf(a1, a1.length + a2.length);
		for (int i = 0; i < a2.length; i++) {
			a3[a1.length + i] = a2[i];
		}
		return a3;
	}

	public T[] concat(T[] a, T item) {
		T[] a2 = Arrays.copyOf(a, 1);
		a2[0] = item;
		return concat(a, a2);
	}

	public boolean contains(T[] array, T item) {
		for (T e : array) {
			if (e.equals(item)) {
				return true;
			}
		}
		return false;
	}
	
}
