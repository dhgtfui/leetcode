/**
 * Function Instruction: LeetCode 7. Reverse Integer
 * Reverse digits of an integer.
 * Developer：jxwang
 * Date：2016, Mar 6
 */
package math;

public class reverse {
	public static void main(String[] args){
		System.out.println(reverse(1534236469));
	}
	public static int reverse(int x) {
        int sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        long res = 0;;
        while(x > 0){
        	res = res * 10 + x %10;
        	x /= 10;
        }
        res = res > Integer.MAX_VALUE? 0:res;
        return (int)res*sign;
    }
}
