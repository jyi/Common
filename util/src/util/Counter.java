package util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Jooyong Yi (jooyong@comp.nus.edu.sg)
 * @date May 31, 2012
 */
public class Counter<T> {

	private Map<T, Integer> counterMap = new HashMap<T, Integer>();

	/**
	 * count the given paramter value.
	 * 
	 * @param t
	 * @return the count number before adding the current one.
	 */
	public int count(T t) {
		Integer rst = counterMap.get(t);
		if (rst == null) {
			return 0;
		} else {
			Integer prev = rst.intValue();
			counterMap.put(t, prev + 1);
			return prev;
		}
	}
}
