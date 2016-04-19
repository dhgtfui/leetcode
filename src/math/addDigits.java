/**
 * Function Instruction: LeetCode 258. Add Digits
 * Given a non-negative integer num, repeatedly add all its digits 
 * until the result has only one digit.
 * Developer：jxwang
 * Date：2016, Mar 6
 */
package math;

public class addDigits {
	public static void main(String[] args){
		System.out.println(addDigits(38));//2
	}
	public static int addDigits(int num) {
       return num - 9 * ((num-1)/9); 	
    }
}
