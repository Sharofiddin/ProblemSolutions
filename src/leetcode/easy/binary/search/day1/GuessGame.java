package leetcode.easy.binary.search.day1;

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */


public class GuessGame {
	int num;
	public class Solution extends GuessGame {
	    public int guessNumber(long begin, long end){
	        if(begin == end)
	            return (int)begin;
	        int guessRes = guess((int)((begin+end)/2));
	        if( guessRes == 0){
	            return (int)((begin+end)/2);
	        } else if(guessRes == 1) {
	            return guessNumber((begin+end)/2+1, end);
	        } else{
	            return guessNumber(begin, (begin+end)/2);
	        }
	    }
	    public int guessNumber(int n) {
	        return guessNumber(1,n);
	    }
	}
	
	public int guess(int n) {
		System.out.println(num + " " +n);
		if(n == num)
			return 0;
		else if( num > n)
		     return 1;
		return -1;
	}
	
	public static void main(String[] args) {
		Solution solution = new GuessGame().new Solution();
		solution.num = 6;
		System.out.println(solution.guessNumber(10));
		solution.num = 1702766719;
		System.out.println(solution.guessNumber(2126753390));
	}
}
