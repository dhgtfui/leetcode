/**
 * Function Instruction: 214. Shortest Palindrome
 * Description: Given a string S, you are allowed to convert it to a palindrome 
 * by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.
 * For example: Given "abcd", return "dcbabcd".
 * Developer：jxwang
 * Date：2016, Apr 11
 */
package string;

public class shortestPalindrome {
	public static void main(String[] args){
		String str = "aacecaaa";
		System.out.print(shortestPalindrome(str));
	}
	//Improve from middle search, O(logn * logn)
	public static String shortestPalindrome(String s) {
		 if(s.length() <=1) return s;
	        int center = (s.length() - 1) /2;
	        String res = "";
	        for(int i = center; i>=0; i--) {
	            if(s.charAt(i) == s.charAt(i+1)){
	                if((res = isPalindrome(s, i, i+1)) != null) return res;
	            }
	            
	            if((res = isPalindrome(s, i, i)) != null) return res;
	        }
	        return res;
	    }
	public static String isPalindrome(String s, int left, int right) {
	        int i = 1;
	        for(;left-i>=0 && right+i< s.length(); i++) {
	            if(s.charAt(left-i) != s.charAt(right+i)) break;
	        }
	        if(left-i>=0) return null;
	        StringBuilder sb = new StringBuilder(s.substring(right+i));
	        sb.reverse();
	        return sb + s;
	}
	//TLE, for one case [aaaaaa...]
	public static String shortestPalindrome1(String s) {
        if(s.length() == 0)
        	return "";
        if(s.length() == 1)
        	return s;
        String res = "";
        //find the longest palindrome, starting from s[0...i]
        int len = 1;
        for(int i = 0; i < s.length(); i++){
        	int low = 0, high = i;
        	boolean flag = true;	
        	while(low < high){
        		if(s.charAt(low) != s.charAt(high)){
        			flag = false;
        			break;
        		}
        		low++;high--;
        	}
        	if(flag && len < i+1){
        		len = i+1;
        	}
        }
        
        //Got s.substring(0,len), then reverse s.substring(len, s.length())
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(len, s.length()));
        sb.reverse();
        sb.append(s);
        return sb.toString();
    }
}
