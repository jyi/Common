package util.data;

import java.util.ArrayList;

import util._Debug;
import util._Debug.Message;

@SuppressWarnings("serial")
public class _Stack<T extends Copyable<T>> extends ArrayList<T> implements
		Copyable<_Stack<T>> {

	private final String id;

	public _Stack() {
		this.id = "$no id";
	}

	public _Stack(String id) {
		this.id = id;
	}

	public _Stack<T> deepCopy() {
		_Stack<T> clone = new _Stack<T>(id);

		for (int i = 0; i < this.size(); i++) {
			T original = this.get(i);
			T copy = original.deepCopy();
			clone.add(copy);
		}

		return clone;
	}

	public int height() {
		return this.size();
	}

	public T peek() {
		assert this.size() > 0;
		return this.get(this.size() - 1);
	}

	public T pop() {
		assert this.size() > 0;
		final T removed = this.remove(this.size() - 1);
		_Debug.println(false, new Message() {

			public String message() {
				StringBuffer sb = new StringBuffer();
				sb.append("pops " + removed);
				return sb.toString();
			}

			public String sort() {
				return "stack";
			}
		});
		return removed;
	}

	public void push(T elem) {
		this.add(elem);
	}

	public _Stack<T> shallowCopy() {
		_Stack<T> clone = new _Stack<T>();

		for (int i = 0; i < this.size(); i++) {
			clone.add(this.get(i).shallowCopy());
		}

		return clone;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");

		for (int i = 0; i < height(); i++) {
			sb.append(this.get(i));
		}

		sb.append("]");
		return sb.toString();
	}

}
