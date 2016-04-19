/**
 * Function Instruction: LeetCode 54. Spiral Matrix + 59. Spiral Matrix II
 * Developer：jxwang
 * Description: Given a matrix of m x n elements (m rows, n columns), 
 * return all elements of the matrix in spiral order.
 * Date：2016, Mar 17
 */
package array;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
	public static void main(String[] args){
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		matrix=generateMatrix(3);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	//59. Spiral Matrix II
	public static int[][] generateMatrix(int n) {
		int[][] matrix = null;
		if (n<0) {
			return matrix;
		}
		matrix = new int[n][n];
		int num = 1;
		int left = 0, right = n - 1, top = 0, bottom = n - 1;
		while(left<right && top<bottom){
			for (int i = left; i < right; i++) {
				matrix[top][i] = num++;
			}
			for (int i = top; i < bottom; i++) {
				matrix[i][right] = num++;
			}
			for (int i = right; i > left; i--) {
				matrix[bottom][i] = num++;
			}
			for (int i = bottom; i > top; i--) {
				matrix[i][left] = num++;
			}
			left++;
			right--;
			top++;
			bottom--;
		}
				if ((n&1) != 0) {
			matrix[n/2][n/2] = num;
		}
		return matrix;
    }
	//54. Spiral Matrix
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int a = 0, b = 0;
        
        while(a < (m+1)/2 && b < (n+1)/2){
        	//special case
        	if(m == 2*a+1 && n == 2*b+1){
            	res.add(matrix[a][b]);
            	break;
            }
            else if(m == 2*a+1){
            	for(int j = b; j < n-b; j++)
            		res.add(matrix[a][j]);
            	break;
            }
            else if(n == 2*b+1){
            	for(int i = a; i < m-a; i++)
            		res.add(matrix[i][b]);
            	break;
            } 
        	// first horizontal row without last element
        	for(int j = b; j < n - 1 - b; j++){
        		res.add(matrix[a][j]);
        	}
        	// vertical column on right-hand side
        	for(int i = a; i < m - 1 - a; i++){
        		res.add(matrix[i][n-1-b]); 
        	}
        	for(int j = n - 1 - b; j > b; j--){
        		res.add(matrix[m-1-a][j]);
        	}
        	for(int i = m - 1 - a; i > a; i--){
        		res.add(matrix[i][b]);
        	}
        	a++;
        	b++;
        }
        return res;
    }
}
