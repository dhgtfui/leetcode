/**
 * Function Instruction: LeetCode 73. Set Matrix Zeroes
 * Developer：jxwang
 * Date：2016, Mar 2
 */
//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
package array;

public class setZeroes {
	public static void main(String[] args){
		int[][] m = {};
		isPrint(m);
		System.out.println("After: ");
		setZeroes(m);
		isPrint(m);
	}
	public static void isPrint(int[] [] list){
		for(int i = 0; i < list.length; i++){
			for(int j = 0; j < list[i].length; j++){
				System.out.print(list[i][j]);
			}
			System.out.println();
		}
	}
	public static void setZeroes(int[][] matrix) {
		if(matrix.length == 0 || matrix[0].length == 0 || matrix == null)
			return;
		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				if(matrix[i][j] == 0){
					row[i] = 1;
					column[j] = 1;
				}
			}
		}
		for(int i = 0; i < matrix.length; i++){
			if(row[i] == 1){
				for(int j = 0; j < matrix[i].length; j++)
					matrix[i][j] = 0;
				}
			}
		for(int i = 0; i < matrix[0].length; i++){
			if(column[i] == 1){
				for(int j = 0; j < matrix.length; j++)
					matrix[j][i] = 0;
				}
			}
    }
}
