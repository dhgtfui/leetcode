/**
 * Function Instruction: LeetCode 69. Sqrt(x)
 * Developer：jxwang
 * Date：2016, Mar 3
 */
//Implement int sqrt(int x). Compute and return the square root of x.
package binarySearch;

public class mySqrt {
	public static void main(String[] args){
		System.out.println(mySqrt(9));
	}
	public static int mySqrt(int x) {
        if(x == 0)
        	return 0;
        double res = 1, left = 0;
        while(left != res){
        	left = res;
        	res = (res + x/res)/2;
        }
        return (int)res;
    }
}
