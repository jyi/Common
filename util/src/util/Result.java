package util;

/**
 * It holds the evaluation result of an IFun application.
 * 
 * @author Jooyong Yi
 */
public class Result<T> {

	private T val;
	private boolean defined = false;

	public void set(T val) {
		this.val = val;
		this.defined = true;
	}

	public T get() {
		assert defined;
		return val;
	}

	public boolean defined() {
		return defined;
	}

}
