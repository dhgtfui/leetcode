/**
 * Function Instruction: LeetCode 74. Search a 2D Matrix
 * Developer：jxwang
 * Date：2016, Mar 4
 */
package binarySearch;

public class searchMatrix {
	public static void main(String[] args){
		int[][] test1 = {{1,3,5,7}, {10,11,16,20},{23,30,34,50}}; 
		int[][] test3 = {{1}};
		int[][] test2 = {{1, 4, 7, 11, 15}, {2, 5,  8, 12, 19},{3, 6,  9, 16, 22}, {10, 13, 14, 17, 24},{18, 21, 23, 26, 30} };
		//searchMatrix2(test2,5);//searchMatrix2(test2,5)->true, searchMatrix2(test2,20)->false
		if(searchMatrix2(test2,20))
			System.out.println("Yes");
		else
			System.out.println("No");//searchMatrix1(test1,3)->true
	}
	public static boolean searchMatrix1(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0)
			return false;
		if(matrix[0][0] > target)
			return false;
        int low = 0, high = matrix.length - 1; 
        while(low <= high){
        	
        	int mid = low + (high - low)/2;
        	if(matrix[mid][0] == target)
        		return true;
        	else if(matrix[mid][0] > target)
        		high = mid - 1;
        	else
        		low = mid + 1;
        }
        int left = 0, right = matrix[0].length - 1;
        while(left <= right){
        	int mid = left + (right - left)/2;
        	if(matrix[low - 1][mid] == target)
        		return true;
        	else if(matrix[low - 1][mid] > target)
        		right = mid - 1;
        	else
        		left = mid + 1;
        }
        return false;
    }
	//240. Search a 2D Matrix II
	public static boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null)
        	return false;
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
        	if(matrix[i][j] == target)
        		return true;
        	else if(matrix[i][j] < target)
        		i++;
        	else
        		j--;
        }
        return false;
    }
}
