/**
 * Function Instruction: LeetCode 120. Triangle
 * Developer：jxwang
 * Date：2016, Mar 5
 */
package dynamicProgramming;
import java.util.*;
public class minimumTotal {
	public static void main(String[] args){
		List<List<Integer>> dp = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> l3 = new ArrayList<Integer>();
		List<Integer> l4 = new ArrayList<Integer>();
		l1.add(-1);
		l2.add(2);
		l2.add(3);
		l3.add(1);
		l3.add(-1);
		l3.add(-3);
		
		dp.add(l1);
		dp.add(l2);
		dp.add(l3);
		
		
		System.out.println(minimumTotal(dp));
	}
	//Given a triangle, find the minimum path sum from top to bottom
	public static int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size() < 1 || triangle == null)
            return 0;
        int len = triangle.size();
        int[][] dp = new int[len][];
        for(int i = 0; i < len; i++)
            dp[i] = new int[i+1];
        dp[0][0] = triangle.get(0).get(0);
        //dp
        for(int i = 1; i < len; i++){
            List<Integer> tmp = triangle.get(i);
            for(int j = 0; j < tmp.size(); j++){
                if(j == 0)
                    dp[i][0] = dp[i-1][0] + tmp.get(0);
                else if(j == i)
                    dp[i][j] = dp[i-1][i-1] + tmp.get(i);
                else if(j < i)  
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + tmp.get(j);
            }
        }
        //find the minimum in dp[len-1][j]
        int min = dp[len-1][0];
        for(int i = 1; i < len; i++){
            min = min < dp[len-1][i] ? min : dp[len-1][i];
        }
        return min;
    }
}
