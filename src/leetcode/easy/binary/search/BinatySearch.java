package leetcode.easy.binary.search;

class Solution {
	public int searchIn(int[] nums, int begin, int end, int target) {
		if(target == nums[(begin+end)/2])
			return (begin+end)/2;
		if(begin == end)
			return -1;
		if(target > nums[(begin+end)/2]) {
			return searchIn(nums, (begin+end)/2+1, end, target);
		} else {
			return searchIn(nums, begin, (begin+end)/2, target);
		}
	}
    public int search(int[] nums, int target) {
    	return searchIn(nums, 0, nums.length-1, target);
    	
    }
}

public class BinatySearch {
	public static void main(String[] args) {
		int arr1[] = {-1,0,3,5,9,12};
		System.out.println(new Solution().search(arr1, 9));
		int arr2[] =  {-1,0,3,5,9,12};
		System.out.println(new Solution().search(arr2, 2));
		int arr3[] =  {5};
		System.out.println(new Solution().search(arr3, -5));
		int arr4[] ={2,5};
		System.out.println(new Solution().search(arr4, 0));
	}
}
