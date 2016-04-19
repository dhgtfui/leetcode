/**
 * Function Instruction: 5. Longest Palindromic Substring
 * Description: Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * Developer：jxwang
 * Date：2016, Apr 10
 */
package string;

public class longestPalindrome {
	public static void main(String[] args){
		String str = "abcba";
		System.out.print(longestPalindrome(str));
	}
	//dp,O(n^2)
	public static String longestPalindrome(String s) {
		if(s.length() == 0)
			return "";
		if(s.length() == 1)
			return s;
		boolean[][] dp = new boolean[s.length()][s.length()];
		for(int i = 0; i < s.length(); i++){
			for(int j = 0; j < s.length(); j++){
				if(i >= j)
					dp[i][j] = true;
			}
		}
		int len = 1;
		int left=0, right=0;
		for(int k = 1; k < s.length(); k++){
			for(int i = 0; i < s.length() - k; i++){
				int j = i + k;
				if(s.charAt(i) != s.charAt(j)){
					dp[i][j] = false;
				}
				else{
					dp[i][j] = dp[i+1][j-1];
					if(dp[i][j]){
						if(k+1 > len){
							len = k + 1;
							left = i; right = j;
						}
					}
				}
			}
		}
		return s.substring(left, right+1);
	}
	//Violence Solution O(n^3)
	public static String longestPalindrome1(String s) {
        int len = 0;
        String res = "";
        for(int i = 0; i < s.length(); i++){
        	for(int j = i+1; j <= s.length(); j++){
        		//s.substring(i,j) is palindrome?
        		String tmp = s.substring(i,j);
        		int low = 0;
        		int high = tmp.length()-1;
        		boolean flag = true;
        		while(low < high){
        			if(tmp.charAt(low) != tmp.charAt(high)){
        				flag = false;
        				break;
        			}
    				low++;high--;
        		}
        		if(flag && len < tmp.length()){
        			len = tmp.length();
        			res = tmp;
        		}
        	}
        }
        return res;
	}
}
