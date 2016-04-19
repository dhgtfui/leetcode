/**
 * Function Instruction: LeetCode 202. Happy Number
 * Developer：jxwang
 * Date：2016, Mar 6
 */
package math;

public class isHappy {
	public static void main(String[] args){
		System.out.println(isHappy(19));
	}
	public static boolean isHappy(int n) {
		if(n <= 0)
            return false;
        if(n == 1)
            return true;
        while(n > 6){
            int res = 0;
            while(n != 0){
                res += (n%10) * (n%10);
                n /= 10;
            }
            n = res;
        }
        return n == 1;
    }
}
