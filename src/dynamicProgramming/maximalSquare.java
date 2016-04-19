/**
 * Function Instruction: LeetCode 221. Maximal Square
 * Description: Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest square containing all 1's and return its area.
 * Developer：jxwang
 * Date：2016, Apr 12
 */
package dynamicProgramming;

public class maximalSquare {
	public static void main(String[] args){
		char[][] matrix = {{'1', '0', '1', '0', '0'},{'1', '0', '1', '1', '1'},{'1', '1', '1', '1', '1'}};
		//System.out.print(maximalSquare(matrix));
		int[][] res = {};
		System.out.println(res[0].length);
	}
	public static int maximalSquare(char[][] matrix) {
		if(matrix==null || matrix.length == 0 || matrix[0].length == 0) 
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i = 1; i <= m; i++){
        	for(int j = 1; j <= n; j++){
        		if(matrix[i - 1][j - 1] == '1'){
            		dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1])+1;
            		max = Math.max(max, dp[i][j]);
        		}
        	}
        }
        return max*max;
    }
}
