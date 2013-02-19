package util.data;

public interface Copyable<T> {

	T deepCopy();
	
	T shallowCopy();
}
