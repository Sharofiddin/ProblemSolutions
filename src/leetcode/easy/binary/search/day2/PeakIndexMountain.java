package leetcode.easy.binary.search.day2;

public class PeakIndexMountain {
	class Solution {
		public int peakIndexInMountainArray(int[] arr) {
			return mountainSearch(arr, 0, arr.length);

		}

		private int mountainSearch(int[] arr, int begin, int end) {
			int i = (begin + end) / 2;
			if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
				return i;
			}
			if (arr[i] < arr[i - 1]) {
				return mountainSearch(arr, begin, i);
			} else {
				return mountainSearch(arr, i + 1, end);
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0 };
		Solution s = new PeakIndexMountain().new Solution();
		System.out.println(s.peakIndexInMountainArray(arr));
		int[] arr1 = { 0, 2, 1, 0 };
		System.out.println(s.peakIndexInMountainArray(arr1));
		int[] arr2 = { 0, 10, 5, 2 };
		System.out.println(s.peakIndexInMountainArray(arr2));
	}
}
