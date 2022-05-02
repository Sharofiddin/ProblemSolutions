package leetcode.easy.binary.search.day3;

import java.util.Arrays;

public class DistanceBetweenTwoArrays {
	class Solution {
		public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
			int res = 0;
			Arrays.sort(arr2);
			for (int a : arr1) {
				int nearest = findNearest(arr2, 0, arr2.length - 1, a);
				if (Math.abs(nearest - a) > d) {
					res++;
				}
			}
			return res;
		}

		private int findNearest(int[] arr, int begin, int end, int num) {
			if (begin == end) {
				return begin != 0 && Math.abs(num - arr[begin]) < Math.abs(num - arr[begin-1]) ? 
						 arr[begin] : arr[begin-1];
			}
			int choice = arr[(begin + end) / 2];
			if (choice == num)
				return num;
			if (choice > num) {
				return findNearest(arr, begin, (begin + end) / 2, num);
			} else {
				return findNearest(arr, (begin + end) / 2 + 1, end, num);
			}
		}
	}

	public static void main(String[] args) {
		Solution s = new DistanceBetweenTwoArrays().new Solution();
		int[] arr1 = { 4, 5, 8 };
		int[] arr2 = { 10, 9, 1, 8 };
		System.out.println(s.findTheDistanceValue(arr1, arr2, 2));
		int[] arr3 = { 2, 1, 100, 3 };
		int[] arr4 = { -5, -2, 10, -3, 7 };
		System.out.println(s.findTheDistanceValue(arr3, arr4, 6));
		int[] arr5 = { 1, 4, 2, 3 };
		int[] arr6 = { -4, -3, 6, 10, 20, 30 };
		System.out.println(s.findTheDistanceValue(arr5, arr6, 3));
		int[] arr7 = { -803, 715, -224, 909, 121, -296, 872, 807, 715, 407, 94, -8, 572, 90, -520, -867, 485, -918,
				-827, -728, -653, -659, 865, 102, -564, -452, 554, -320, 229, 36, 722, -478, -247, -307, -304, -767,
				-404, -519, 776, 933, 236, 596, 954, 464 };
		int[] arr8 = { 817, 1, -723, 187, 128, 577, -787, -344, -920, -168, -851, -222, 773, 614, -699, 696, -744, -302,
				-766, 259, 203, 601, 896, -226, -844, 168, 126, -542, 159, -833, 950, -454, -253, 824, -395, 155, 94,
				894, -766, -63, 836, -433, -780, 611, -907, 695, -395, -975, 256, 373, -971, -813, -154, -765, 691, 812,
				617, -919, -616, -510, 608, 201, -138, -669, -764, -77, -658, 394, -506, -675, 523, 730, -790, -109,
				865, 975, -226, 651, 987, 111, 862, 675, -398, 126, -482, 457, -24, -356, -795, -575, 335, -350, -919,
				-945, -979, 611 };
		Arrays.sort(arr8);
		System.out.println(s.findTheDistanceValue(arr7, arr8, 37));
	}
}
