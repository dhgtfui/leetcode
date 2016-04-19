/**
 * Function Instruction: 125-Valid Palindrome
 * Developer：jxwang
 * Date：2016, Feb 2
 */
package string;

public class isPalindrome {
	public static void main(String[] args){
		String str="";
		System.out.println(isPalindrome(str));
	}
	public static boolean isPalindrome(String s) {
		if (s == null) {
            return true;
        }
		int i = 0;
        int j = s.length() - 1;
		while(i<j)
        {
            if(!Character.isLetterOrDigit(s.charAt(i))){
            	i++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(j))){
            	j--;
            }
            else if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
            	return false;
            }
            else{
            	i++;
                j--;
            }
        }
        return true;
    }
}
