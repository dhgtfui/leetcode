/**
 * Function Instruction: LeetCode 93. Restore IP Addresses
 * Description:Given a string containing only digits, 
 * restore it by returning all possible valid IP address combinations.
 * Developer：jxwang
 * Date：2016, Apr 10
 */
package backtracking;

import java.util.*;

public class restoreIpAddresses {
	public static void main(String[] args){
		System.out.print(restoreIpAddresses("25525511135"));
	}
	public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        dfs(result, s, "", 0, "", 0);
        return result;
    }
    private static void dfs(List<String> result, String s, String temp, int curIndex, String curSum, int times) {
        if (times < 4 && times > 0) {
            temp = temp + curSum + '.';
            curSum = "";
        } else if (times == 4 && curIndex == s.length()) {  
        	//得到4个字段过后，如果curIndex不小于s.length()，那么ip合法
            result.add(temp + curSum);
        }
        for (int i = curIndex; i < s.length() && times < 4; i++) {
            curSum = curSum + s.charAt(i);
            if (curSum.length() > 1 && curSum.startsWith("0") || Integer.parseInt(curSum) > 255) //该字段ip不合法，剪枝
                break;
            dfs(result, s, temp, i + 1, curSum, times + 1);
        }
    }
}
