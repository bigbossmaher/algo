package lab3B;

public class RecursiveFibWithMemoization {
	
	public static int [] holderArray= new int [20];
	
	
	public static int fib(int n) {
		
		int fibVlaue=0;
		
		if(n < 0) return -1;
		if(n==0 || n == 1) return n;
		
		else if(holderArray[n]!=0) {
			return holderArray[n];
		}else {
			
			fibVlaue= fib(n-1) + fib(n-2);
			holderArray[n]=fibVlaue;
			return fibVlaue;
	}
	}
	public static void main(String[] args) {
		
		System.out.println(fib(5));
	}
}
