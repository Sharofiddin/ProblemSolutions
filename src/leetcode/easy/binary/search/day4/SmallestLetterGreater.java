package leetcode.easy.binary.search.day4;

public class SmallestLetterGreater {
    class Solution {
	   public char find(char[] arr, int begin, int end, char target) {
	       if(begin == end) {
		   while( begin < arr.length && arr[begin] <= target) {
		       begin++;
		   }
		   
		   return begin == arr.length ? arr[0] : arr[begin];
	       }
	       int choice = (begin +end)/2;
	       if(arr[choice] > target) {
		   return find(arr, begin, choice, target);
	       }else {
		   return find(arr, choice+1, end, target);
	       }
	   }
	    public char nextGreatestLetter(char[] letters, char target) {
	        return find(letters, 0, letters.length-1, target);
	    }
	}
    public static void main(String[] args) {
	Solution s = new SmallestLetterGreater().new Solution();
	char []arr = {'c','f','j'};
	System.out.println(s.nextGreatestLetter(arr, 'a'));
	System.out.println(s.nextGreatestLetter(arr, 'c'));
	System.out.println(s.nextGreatestLetter(arr, 'j'));
	
	
    }
}
