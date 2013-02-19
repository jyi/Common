package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author Jooyong Yi (jooyong@comp.nus.edu.sg)
 * @date May 14, 2012
 * @param <I>
 *            input type
 * @param <O>
 *            output type
 * @param <C>
 *            collection type
 */
public abstract class MapFun<I, O, C extends Collection<O>> {

	protected C newCol;

	public abstract O map(I elem);

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

		for (I t : col) {
			newCol.add(map(t));
		}

		return newCol;
	}

}
