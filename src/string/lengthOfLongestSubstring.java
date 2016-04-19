/**
 * Function Instruction: LeetCode 3 - Longest Substring Without Repeating Characters
 * Developer：jxwang
 * Date：2016, Feb 20
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
package string;

import java.util.Arrays;

public class lengthOfLongestSubstring {
	public static void main(String[] args){
		String s="abcfac";
		final boolean[] a = new boolean[256];
		//System.out.println(a[89]);
		System.out.print(lengthOfLongestSubstring1(s));
	}
	//O(n^2)
	public static int lengthOfLongestSubstring2(String s) {
		if(s == null || s.length() == 0)
			return 0;
		if(s.length() == 1)
			return 1;
		int [] countTable = new int[256];  
        Arrays.fill(countTable, -1);  
        int max = 1;  
        int start = 0;  
        int end = 1; 
        countTable[s.charAt(0)] = 0;  
        while (end < s.length()) {    
            if (countTable[s.charAt(end)] >= start) {  
                start = countTable[s.charAt(end)] + 1;                
            }  
            max = max > (end - start + 1) ? max: (end - start + 1);  
            countTable[s.charAt(end)] = end;  
            end++;  
        }  
        return max;
	}
	
	//brute force，O(n^3)
	public static int lengthOfLongestSubstring1(String s) {
		if(s == null || s.length() == 0)
			return 0;
		if(s.length() == 1)
			return 1;
		int max = 1;
		s = s.toLowerCase();
		//find all substrings and confirm if there is no repeating words
		for(int i = 0; i < s.length()-1; ++i){
			//substring= (s[j] ... s[i])
			for(int j = i+1; j < s.length(); ++j){	
				//Test if s.substring(i, j) has no repeating letters
				if(isUnique(s.substring(i, j)))
					max = max > s.substring(i, j).length() ? max: s.substring(i, j).length();
			}
		}
		return max;
    }
	public static boolean isUnique(String s) {
		int check = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = (int) s.charAt(i);
            int b = check & (1 << v);
            if (b != 0)
            	return false;
            check|=(1 << v);
        }
        return true;
    }
}
