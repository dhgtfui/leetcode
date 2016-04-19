/**
 * Function Instruction: LeetCode 29. Divide Two Integers
 * Developer：jxwang
 * Date：2016, Mar 3
 */
//Divide two integers without using multiplication, division and mod operator.
//If it is overflow, return MAX_INT.
package binarySearch;

public class divide {
	public static void main(String[] args){
		int a = 9;
        int b =(int) Math.sqrt(a);
		//System.out.println(divide(27,-2147483648));
		System.out.println(b);
	}
	public static int divide(int dividend, int divisor) {
		 //overflow
        if(divisor == 0 || (dividend == Integer.MAX_VALUE && divisor == 1) || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        long m = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);
        if(m < n)
            return 0;
      
        //sign
        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
        //loop
        int count = 0;
        while(m >= n){
            //m -= n;
            //count++;
            long tmp = n;
            for(int i = 1; m >= tmp; tmp <<= 1, i <<= 1){
                m -= tmp;
                count += i;
            }
        }
        
        return count*sign;
    }
	public static int divide2(int dividend, int divisor) {
	    final int MAX = 0x7fffffff, MIN = 0x80000000;
	    if(divisor==0 || (divisor==-1 && dividend==MIN)) return MAX;
	    int sign = (dividend>=0 && divisor>0 || dividend<=0 && divisor<0) ? 1 : -1;
	    dividend = dividend>0 ? -dividend : dividend;
	    divisor = divisor>0 ? -divisor : divisor;
	    if(dividend>divisor) return 0;
	    if(divisor==-1) return sign==1 ? -dividend : dividend;
	    int res = 0;
	    while(dividend<=divisor) {
	        int divisorCurrent = divisor;
	        int resCurrent = 1;
	        while(divisorCurrent>dividend>>1) {
	            divisorCurrent = divisorCurrent<<1;
	            resCurrent = resCurrent<<1;
	        }
	        res += resCurrent;
	        dividend -= divisorCurrent;
	    }
	    return sign==1 ? res : -res;
	}
}
