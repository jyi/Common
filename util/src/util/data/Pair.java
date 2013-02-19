package util.data;

public class Pair<E0, E1> extends Tuple {

	public Pair(final E0 e0, final E1 e1) {
		super(e0, e1);
	}

	@SuppressWarnings("unchecked")
	public E0 first() {
		return (E0) this.get(0);
	}

	@SuppressWarnings("unchecked")
	public E1 second() {
		return (E1) this.get(1);
	}

}
