package util;

import java.util.ArrayList;
import java.util.List;

public class Filter {

	public static <T> List<T> apply(IFun<Boolean> f, List<T> list) {
		List<T> result = new ArrayList<T>(list.size());
		for (T e : list) {
			if (f.apply(e)) {
				result.add(e);
			}
		}
		return result;
	}
}
