package lab3B;

public class FibonacciIterative {

	public static int fibonacciIterative(int n) {
		if(n <= 1) {
			return n;
		}
		int fib = 1;
		int prevFib = 1;
		
		for(int i=2; i<n; i++) {
			int temp = fib;
			fib+= prevFib;
			prevFib = temp;
		}
		return fib;
	}
	
	public static void main(String[] args) {
		
		System.out.println(fibonacciIterative(5));

	}

}
