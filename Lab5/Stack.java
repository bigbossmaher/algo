package lab5;

import java.util.LinkedList;

public class Stack extends LinkedList<Integer> {
	 int top = 0;

	public boolean isEmpty() {
		return (top == 0);
	}

	public Integer pop() {
		Integer ob = remove();
		if (ob != null) {
			top--;
		}
		return ob;
	}

	public Integer peek() {
		return this.getLast();
	}

	public void push(Integer val) {
		add(val);
		++top;
	}
}