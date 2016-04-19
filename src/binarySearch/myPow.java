/**
 * Function Instruction: LeetCode 50. Pow(x, n)
 * Developer：jxwang
 * Date：2016, Mar 3
 */
//Implement pow(x, n).
package binarySearch;

public class myPow {
	public static void main(String[] args){
		System.out.print(myPow(2,-3));
	}
	public static double myPow(double x, int n) {
        if(n == 0)
        	return 1;
        if(n == 1)
        	return x;
        double res = 0;
        int index = n > 0 ? n : -n;
        res = index % 2 == 0 ? myPow(x*x,index >>1) : myPow(x*x,index >>1) * x;
        res = n > 0 ? res : 1/res;
        return res;
    }
}
