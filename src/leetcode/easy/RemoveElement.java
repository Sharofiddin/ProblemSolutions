package leetcode.easy;
import java.util.Arrays;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
	int res = nums.length;
	Arrays.sort(nums);
	while (res != 0 && nums[res - 1] == val) {
	    res--;
	}
	if (res == 0)
	    return 0;
	for (int i = 0; i < res; i++) {
	    if (nums[i] == val) {
		if (val == nums[res - 1])
		    return i;
		nums[i] = nums[res - 1];
		nums[res - 1] = val;
		res--;
	    }
	}
	return res;
    }

    public static void main(String[] args) {
	int[] arr1 = { 0, 2, 2, 1, 2, 1, 2, 2, 4 };
	int[] arr2 = { 0, 1, 2, 2, 3, 0, 4, 2 };
	int[] arr3 = { 2, 2, 3 };
	int res = removeElement(arr1, 2);
	System.out.println(res);
	printArr(arr1, res);
	res = removeElement(arr2, 2);
	System.out.println(res);
	printArr(arr2, res);
	res = removeElement(arr3, 2);
	System.out.println(res);
	printArr(arr3, res);
    }

    private static void printArr(int[] arr, int l) {
	for (int i = 0; i < l; i++) {
	    System.out.print(arr[i] + " ");
	}
	System.out.println();
    }
}
