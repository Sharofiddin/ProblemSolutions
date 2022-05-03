package leetcode.medium.binary.search.day6;

public class ArrangingCoins {
	public static class Solution {
		public static int arrangeCoins(int n) {
			return calc(n, 1,n, n);
		}

		private static int calc(int lim, int b, int e, int tar) {
			long sum = (lim + 1L) * lim / 2;
			System.out.println("tar=" + tar + " ,sum=" + sum + " ,lim=" + lim);
			if (Math.abs(sum - tar) <= lim) {
					return sum <= tar ? lim : lim-1;
			}
			if (sum > tar) {
				return calc(b/2+lim/2, b, lim, tar);
			} else {
				return calc(lim/2+e/2, lim, e, tar);
			}
				
			
		}
	}

	public static void main(String[] args) {
		System.out.println(Solution.arrangeCoins(5));
		System.out.println(Solution.arrangeCoins(1));
		System.out.println(Solution.arrangeCoins(2));
		System.out.println(Solution.arrangeCoins(3));
		System.out.println(Solution.arrangeCoins(12));
		System.out.println(Solution.arrangeCoins(8));
		System.out.println(Solution.arrangeCoins(4));
		System.out.println(Solution.arrangeCoins(1804289383));
	}
}
