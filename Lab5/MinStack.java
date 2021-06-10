package lab5;

public class MinStack extends Stack {

	private Stack keepMin = new Stack();
	private Integer minVal;

	public Integer pop() {
		Integer val = remove();
		if (val != null) {
			top--;
			keepMin.pop();
		}
		return val;
	}

	public void push(Integer val) {
		add(val);
		++top;
		if (minVal == null || val < minVal) {
			minVal = val;
		}
		keepMin.push(minVal);
		System.out.println(val+" pushed ");
	}

	public Integer min() {
		return keepMin.peek();
	}

	

}
