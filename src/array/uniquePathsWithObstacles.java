/**
 * Function Instruction: LeetCode 63. Unique Paths II
 * Developer：jxwang
 * Date：2016, Feb 27
 */
package array;

public class uniquePathsWithObstacles {
	public static void main(String[] args){
		int[][] list={{0,0,0},{0,1,0}, {0,0,0}};
		System.out.print(uniquePathsWithObstacles(list));
	}
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1)
        	return 0;
        if(m == 1 || n ==1)
            return 1;
        int[][] dp=new int[m][n];
        dp[0][0] = 1;
        for(int i = 1; i < m; i++){	
        	dp[i][0] = (obstacleGrid[i][0] == 1) ? 0 : dp[i-1][0];
        }
        for(int i = 1; i < n; i++){	
        	dp[0][i] = (obstacleGrid[0][i] == 1) ? 0 : dp[0][i-1];
        }
        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		dp[i][j] = (obstacleGrid[i][j] == 1) ? 0 : (dp[i-1][j] + dp[i][j-1]);
        	}
        }
        return dp[m-1][n-1];
    }
}
