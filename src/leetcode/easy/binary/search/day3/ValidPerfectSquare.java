package leetcode.easy.binary.search.day3;


public class ValidPerfectSquare {
	class Solution {
		
		public boolean isPerfectSquare(int num) {
			return isSquare(num, 0, num);
		}

		private boolean isSquare(long num, long begin, long end) {
			if(begin==end) {
				return begin*begin == num;
			}
			long choice = (begin + end)/2;
			if(choice* choice == num)
				return true;
			if(choice * choice > num) {
				return isSquare(num, begin, choice);
			} else {
				return isSquare(num, choice+1, end);
			}
		}
	}
	public static void main(String[] args) {
		Solution solution = new ValidPerfectSquare().new Solution();
		System.out.println(solution.isPerfectSquare(25));
		System.out.println(solution.isPerfectSquare(625));
		System.out.println(solution.isPerfectSquare(125));
		System.out.println(solution.isPerfectSquare(16));
		System.out.println(solution.isPerfectSquare(2000105819));
	}
}
