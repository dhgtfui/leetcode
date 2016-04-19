/**
 * Function Instruction: LeetCode 66. Plus One
 * Developer：jxwang
 * Date：2016, Feb 21
 */
//Given a non-negative number represented as an array of digits, plus one to the number.
//The digits are stored such that the most significant digit is at the head of the list.
package array;

public class plusOne {
	public static void main(String[] args){
		int[] y={9,8};
		int[] x=plusOne(y);
		for(int i=0; i<x.length;i++){
			System.out.print(x[i]+" ");
		}
	}
	public static int[] plusOne(int[] digits) {
		if(digits.length == 0 || digits == null)
			return digits;
		int flag=1, i;
		for(i = digits.length - 1; i >= 0; i--){
			digits[i]=digits[i]+flag;
			if(digits[i] > 9){
				flag = 1;
				digits[i] = 0;
			}
			else{
				flag = 0;
			}
		}
		if(flag == 1 && i == -1){
			int[] newDigits=new int[digits.length + 1];
			newDigits[0]=1;
			for(int j =1; j < digits.length; j++){
				newDigits[j]=digits[j];
			}
			return newDigits;
		}
		else{
			return digits;
		}
    }
}
