package assignments1b;

public class Problem7GenerateFibSeq {

	public static void main(String[] args) {
		for (int i = 0; i <= 20; ++i) {
			System.out.println(generate(i));
		}

	}

	public static int generate(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return generate(n-1) + generate(n-2);
	}

}
