package sololearn;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordRank {
	static int fact(int num) {
		int ret = 1;
		while (num != 1) {
			ret *= num;
			num--;
		}
		return ret;
	}

	static int calc(String txt) {
		System.out.println(txt);
		ArrayList<Integer> letters = (ArrayList<Integer>) txt.chars().boxed().collect(Collectors.toList());
		if (letters.size() == 1) {
			return 1;
		}

		int lowerValuesCnt = (int) letters.stream().filter(i -> letters.get(0) > i).count();
		
		int duplicated = letters.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().mapToInt(s -> s.getValue().intValue()).reduce(1, (a, b) -> a * fact(b));
		int cnt = lowerValuesCnt * fact(txt.length() - 1) / duplicated;
		System.out.println(lowerValuesCnt + " * (" + (txt.length() - 1) + ")! / (" + duplicated + ")! = " + cnt);
		return cnt + calc(txt.substring(1));

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String txt = sc.nextLine();
		sc.close();
		System.out.println(calc(txt));

	}
}