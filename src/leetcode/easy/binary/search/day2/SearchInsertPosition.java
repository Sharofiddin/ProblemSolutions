package leetcode.easy.binary.search.day2;

class Solution {
    
	public int search(int [] arr, int begin, int end, int target) {
		if(begin == end)
			return begin;
		int idx = (begin +end)/2;
		if(arr[idx] == target)
			return idx;
		if(target > arr[idx])
			return search(arr, idx+1, end, target);
		else
			return search(arr, begin, idx, target);
	}
    public int searchInsert(int[] nums, int target) {
        return search(nums, 0, nums.length, target);
    }
}

public class SearchInsertPosition {
	public static void main(String[] args) {
		 int [] nums = {1,3,5,6};
		 System.out.println(new Solution().searchInsert(nums, 5));
		 int [] nums1  = {1,3,5,6};
		 System.out.println(new Solution().searchInsert(nums1, 2));
		 int [] nums2 = {1,3,5,6};
		 System.out.println(new Solution().searchInsert(nums2, 7));
	}
}
