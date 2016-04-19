/**
 * Function Instruction: LeetCode 9. Palindrome Number
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Developer：jxwang
 * Date：2016, Mar 6
 */
package math;

public class isPalindrome {
	public static void main(String[] args){
		System.out.println(isPalindrome(99));
	}
	public static boolean isPalindrome(int x) {
		if(x < 0)
            return false;
        int t = x, rev = 0;
        while(t > 0){
            rev = rev*10 + t %10;
            t /= 10;
        }
        if(rev == x)
            return true;
        else
            return false;
    }
}
