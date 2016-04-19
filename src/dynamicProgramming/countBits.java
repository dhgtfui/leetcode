/**
 * Function Instruction: LeetCode 338. Counting Bits
 * Description: Given a non negative integer number num. 
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's 
 * in their binary representation and return them as an array.
 * Developer：jxwang
 * Date：2016, Apr 11
 */
package dynamicProgramming;

public class countBits {
	// O(n). O(n).
	public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for(int i = 1; i < num +1 ; i++){
        	res[i] += res[i>>1] + (i & 1);
        }
        return res;
    }
}
