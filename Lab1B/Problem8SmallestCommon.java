package assignments1b;

public class Problem8SmallestCommon {
	public static void main(String[] args) {
		int first = 7;
		int second = 14;
		System.out.println("Smallest Common factor: " + smallestCommon(first, second));
	}

	public static int smallestCommon(int x, int y) {
		int gcd = greatestCommonDivisor(x, y);
		int multiplication = x * y;
		return multiplication / gcd;
	}

	private static int greatestCommonDivisor(int x, int y) {
		if (y != 0)
			return greatestCommonDivisor(y, x % y);
		else
			return x;
	}
}
