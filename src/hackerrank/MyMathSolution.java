package hackerrank;

import java.io.*;
import java.util.*;

interface PerformOperation {
	boolean check(int a);
}

class MyMath {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	PerformOperation isOdd() {
		return a -> (a & 2) == 0;
	}

	PerformOperation isPrime() {
		return a -> {
			for (int i = 2; i <= Math.pow(a, 0.5); i++) {
				if ((a % i) == 0)
					return false;
			}
			return a > 1;
		};
	}

	PerformOperation isPalindrome() {
		return a -> {
			int num = a;
			int reversed = 0;
			while (num != 0) {
				reversed = reversed * 10 + num % 10;
				num /= 10;
			}
			return a == reversed;

		};
	}
}

public class MyMathSolution {

	public static void main(String[] args) throws IOException {
		MyMath ob = new MyMath();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		while (T-- > 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (ch == 1) {
				op = ob.isOdd();
				ret = MyMath.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			} else if (ch == 2) {
				op = ob.isPrime();
				ret = MyMath.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			} else if (ch == 3) {
				op = ob.isPalindrome();
				ret = MyMath.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

			}
			System.out.println(ans);
		}
	}
}
