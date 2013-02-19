package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Map functions
 * 
 * @author Jooyong Yi
 */
public class _Map {

	public static <T1, T2> List<T2> apply(IFun<T2> f, List<T1> list) {
		List<T2> result = new ArrayList<T2>(list.size());
		for (T1 e : list) {
			result.add(f.apply(e));
		}
		return result;
	}

}
