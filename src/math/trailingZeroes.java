/**
 * Function Instruction: LeetCode 172. Factorial Trailing Zeroes
 * Description: Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * Developer：jxwang
 * Date：2016, Mar 6
 */
package math;

public class trailingZeroes {
	public static void main(String[] args){
		System.out.print(countPrimes(15));
	}
	public static int trailingZeroes(int n) {
        if(n <= 0)
        	return 0;
        int res = 0;
        while(n > 1){
        	n /= 5;
        	res += n;
        }
        return res;
    }
	//168. Excel Sheet Column Title
	public static String convertToTitle(int n) {
		String str = "";
        while(n > 0){
            if(n%26 != 0)
                str = (char)(n%26 +'A' -1) + str;
            else
                str = 'Z' +str;
            n = (n-1)/26;
        }
        return str;
	}
	public static int titleToNumber(String s) {
		int res = 0;
        for(int i = 0; i < s.length(); i++){
        	res *= 26;
        	res += s.charAt(i) - 'A' +1;   	
        }
        return res;
    }
	//204. Count Primes
	public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for(int i = 2; i < n; i++){
            isPrime[i] = true;
        }
        for(int i = 2; i*i < n; i++){
            //isPrime[i] = false;
            if(!isPrime[i]) continue;
            for(int j = i * i; j < n; j +=i){
                isPrime[j] = false;
            }
        }
        int count = 0;
        for(int i = 1; i < n; i++){
            if(isPrime[i])
                count++;
        }
        return count;}
}
