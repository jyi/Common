package util.data;

import java.util.Map;

public class Tuple {

	public static <T> Tuple cons(T[] array) {
		return new Tuple(array);
	}

	private Object[] contents;
	private Map<String, Integer> idMap;

	public Tuple(Map<String, Integer> idMap, Object... vals) {
		assert idMap.keySet().size() == vals.length;

		this.idMap = idMap;
		contents = new Object[vals.length];
		for (int i = 0; i < vals.length; i++) {
			contents[i] = vals[i];
		}
	}

	public Tuple(Object... vals) {
		contents = new Object[vals.length];
		for (int i = 0; i < vals.length; i++) {
			contents[i] = vals[i];
		}
	}

	public Object[] contents() {
		return this.contents;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Tuple)) {
			return false;
		}

		Tuple t = (Tuple) o;

		if (size() != t.size()) {
			return false;
		}

		for (int i = 0; i < size(); i++) {
			if (get(i) == null) {
				if (t.get(i) != null) {
					return false;
				}
			} else if (!get(i).equals(t.get(i))) {
				return false;
			}
		}
		return true;
	}

	public Object get(int index) {
		return contents[index];
	}

	public Object get(String id) {
		assert idMap != null;
		Integer index = idMap.get(id);
		assert index != null;
		return get(index);
	}

	@Override
	public int hashCode() {
		int sum = 0;
		int f = 2;
		for (Object o : contents) {
			sum += o == null ? 0 : f * o.hashCode();
			f *= 2;
		}

		return sum;
	}

	public int size() {
		return contents.length;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < contents.length; i++) {
			sb.append(contents[i].toString());
			if (i < contents.length - 1) {
				sb.append(", ");
			}
		}
		sb.append(">");
		return sb.toString();
	}
}
