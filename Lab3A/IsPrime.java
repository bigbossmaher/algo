package lab3A;

public class IsPrime {

	//static int i=1;
	public static int isPrime(int n ,int i) {
	
		// base case
		if (n<=2) return (n==2)?0:1;
		if (n%i==0) return 0;
		if (i*i>n) return 1;
		
		return isPrime(n, i+1);
		
		
	}
	public static void main(String[] args) {
		System.out.println(isPrime(9,2));

	}

}
