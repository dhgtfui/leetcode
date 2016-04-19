/**
 * Function Instruction: LeetCode 48. Rotate Image
 * Developer：jxwang
 * Date：2016, Mar 4
 */
package array;

public class rotateArray {
	public static void main(String[] args){
		int[][] test= {{1,2},{3,4}};
		isPrint(test);
		rotate(test);
		isPrint(test);
	}
	public static void rotate(int[][] matrix) {
		int n = matrix.length - 1;
        for(int i = 0; i <= n/2; i++){
        	for(int j = i; j < n - i; j++){
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[n - j][i];
        		matrix[n - j][i] = matrix[n - i][n - j];
        		matrix[n - i][n - j] = matrix[j][n - i];      		
        		matrix[j][n - i] = tmp;
        	}
        }
    }
	public static void isPrint(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j< matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
