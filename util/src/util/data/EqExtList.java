package util.data;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class EqExtList<E> extends ArrayList<E> {

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof EqExtList)) {
			return false;
		}

		@SuppressWarnings("unchecked")
		EqExtList<E> t = (EqExtList<E>) o;
		for (int i = 0; i < size(); i++) {
			if (!get(i).equals(t.get(i))) {
				return false;
			}
		}

		return true;
	}
}
