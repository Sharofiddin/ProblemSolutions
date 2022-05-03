package leetcode.medium.binary.search.day5;

import java.util.Arrays;

public class FirstLastPositionElementSortedArray {
	static class Solution {
		public static int getIndex(int[] nums, int b, int e, int target) {
			if(b == e) {
				return nums[b] == target ? b : -1;
			}
			int choice = b/2 + e/2;
			if(nums[choice] == target )
				return choice;
			if(nums[choice] > target)
				return getIndex(nums, b, choice, target);
			else
				return getIndex(nums, choice + 1, e, target);
		}
	    public static int[] searchRange(int[] nums, int target) {
	    	int [] arr = new int[2];
	    	arr[0] = -1;
	    	arr[1] = -1;
	    	if(nums.length == 0)
	    		return arr;
	    	int index = getIndex(nums, 0, nums.length-1, target);
	    	if(index == -1)
	    		return arr;
	    	int firstIndex = index;
	    	int lastIndex = index;
	    	while(firstIndex!=0 && nums[firstIndex-1]==target)
	    		firstIndex--;
	    	while(lastIndex!=nums.length-1 && nums[lastIndex+1]==target)
	    		lastIndex++;
	    	arr[0]= firstIndex;
	    	arr[1] = lastIndex;
	    	return arr;
	    }
	}
	
	public static void main(String[] args) {
		int arr1[] = { 5,7,7,8,8,10};
		int arr2[] = {2,2};
		int arr3[]= {};
		System.out.println(Arrays.toString(Solution.searchRange(arr1, 8)));
		System.out.println(Arrays.toString(Solution.searchRange(arr1, 6)));
		System.out.println(Arrays.toString(Solution.searchRange(arr2, 3)));
		System.out.println(Arrays.toString(Solution.searchRange(arr2, 1)));
		System.out.println(Arrays.toString(Solution.searchRange(arr3, 0)));
	}
}
