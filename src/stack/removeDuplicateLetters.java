/**
 * Function Instruction: LeetCode 316. Remove Duplicate Letters
 * Developer：jxwang
 * Date：2016, Mar 11
 * Description: Given a string which contains only lowercase letters, remove duplicate letters 
 * so that every letter appear once and only once. 
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 */
package stack;

public class removeDuplicateLetters {
	public static void main(String[] args){
		String test = "  ";
		
		System.out.println(test.length());
		//System.out.println(removeDuplicateLetters(test));
	}
	public static String removeDuplicateLetters(String s) {
		if(s == null || s.length() == 0)
            return s;
        int len = s.length();
        //find the minimum letter
        int position = 0;
        int[] count = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; 
        }
        for(int i = 0; i < len; i++){
            if(s.charAt(i) < s.charAt(position))
                position = i;
            count[s.charAt(i) - 'a']--;
            if(count[s.charAt(i) - 'a'] == 0)
                {break;}
        }
        String charToRemove = String.valueOf(s.charAt(position));
        return charToRemove + removeDuplicateLetters(s.substring(position + 1).replaceAll(charToRemove, ""));
	}
}
