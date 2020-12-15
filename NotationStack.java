import java.util.ArrayList;
/**
 * Interface for a generic Stack data structure
 * @author Justin Hixson
 *
 * @param <T> data type
 */
public class NotationStack<T> implements StackInterface<T> {

	private int top;
	private T[] data;
	/**
	 * takes an int as the size of the queue
	 * @param size the size of the queue
	 */
	public NotationStack(int size) {
		data = (T[]) new Object[size];
		top = -1;
	}
	/**
	 * default constructor - uses a default as the size of the queue
	 */
	public NotationStack() {

		data = (T[]) new Object[20];
		top = -1;
	}
	/**
	 * takes an ArrayList as a parameter, and fills the Queue with the
	 * @param list an ArrayList
	 */
	public NotationStack(ArrayList<T> list) {
		data = (T[]) new Object[list.size()];
		top = -1;
		for (int i = 0; i < list.size(); i++) {
			data[i] = (T) list.get(i);
			top++;
		}
	}
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		if (top == data.length - 1)
			return true;
		return false;
	}
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T pop() throws StackUnderflowException {
		T element;
		if (!isEmpty()) {
			element = data[top];
			data[top] = null;
			top--;

			return element;
		} else
			throw new StackUnderflowException();
	}
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T top() throws StackUnderflowException {
		T t;
		if (!isEmpty())
			t = data[top];
		else
			throw new StackUnderflowException();

		return t;
	}
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return top + 1;
	}
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		if (!isFull()) {
			data[top + 1] = e;
			top++;
			return true;
		} else
			throw new StackOverflowException();
	}
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		String str = "";
		for (T e : data) {
			if (e == null)
				return str;
			str += e;
		}
		return str;
	}
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String string = "";
		
		for (int i = 0; i < size(); i++) {
			if (i == size() - 1)
				return string + data[i];

			string += data[i] + delimiter;

		}
		return string;
	}
}
