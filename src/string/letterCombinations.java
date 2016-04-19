/**
 * Function Instruction: LeetCode 17. Letter Combinations of a Phone Number
 * Description:Given a digit string, return all possible letter combinations 
 * that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Developer：jxwang
 * Date：2016, Apr 10
 */
package string;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
	public static void main(String[] args){
		String str = ""; 
		System.out.print(letterCombinations(str));
	}
	public static List<String> letterCombinations(String digits) {
        String[] s = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
        	return res;
        dfs(s,res, new StringBuilder(), digits,digits.length());
        return res;
	}
	public static void dfs(String[] s, List<String> res, StringBuilder sb, String digits, int num){
		if(num == 0){
			res.add(sb.toString());
			return;
		}
		String st = s[digits.charAt(0)-'0'];
		for(int i = 0; i < st.length(); i++){
			sb.append(st.charAt(i));
			dfs(s,res,sb,digits.substring(1),num-1);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
