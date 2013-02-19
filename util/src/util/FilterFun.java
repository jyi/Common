package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public abstract class FilterFun<I, C extends Collection<I>> {
	
	private C newCol;

	public abstract boolean filter(I elem);

	@SuppressWarnings("unchecked")
	public C apply(Collection<I> col) {
		Class<?> c = col.getClass();
		if (_Class.isSubtype(c, List.class)) {
			newCol = (C) new ArrayList<I>();
		} else if (_Class.isSubtype(c, Set.class)) {
			newCol = (C) new HashSet<I>();
		} else if (_Class.isSubtype(c, Queue.class)) {
			newCol = (C) new LinkedList<I>();
		} else {
			throw new Error("Unsupport " + col.getClass().getName());
		}

		for (I i : col) {
			if (filter(i)) {
				newCol.add(i);
			}
		}

		return newCol;
	}
}
