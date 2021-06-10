package assignments1b;

public class MathProblem6Log2 {
	public static void main(String[] args) {
		System.out.printf("%.2f", log2(4));
	}
	public static double log2(double x) {
		return Math.log(x)/ Math.log(2);
	}
}
