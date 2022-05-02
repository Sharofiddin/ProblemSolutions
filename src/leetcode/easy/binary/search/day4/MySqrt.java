package leetcode.easy.binary.search.day4;

public class MySqrt {
    class Solution {
	public int mySqrt(int x) {
	    return sqrt(1, x, x);
	}

	private int sqrt(long begin, long end, long x) {
	    if (begin == end) {
		return (int) (begin * begin > x ? begin - 1 : begin);
	    }
	    long choice = (begin + end) / 2;
	    if (choice * choice == x)
		return (int) choice;
	    if (choice * choice > x) {
		return sqrt(begin, choice, x);
	    } else {
		return sqrt(choice + 1, end, x);
	    }
	}
    }

    public static void main(String[] args) {
	Solution solution = new MySqrt().new Solution();
	System.out.println(solution.mySqrt(2));
	System.out.println(solution.mySqrt(2147395599));
	System.out.println(solution.mySqrt(9));
	System.out.println(solution.mySqrt(675));
    }
}
