/**
 * Function Instruction: LeetCode 42. Trapping Rain Water
 * Developer：jxwang
 * Date：2016, Mar 4
 */
package array;

public class trap {
	public static void main(String[] args){
		int[] list = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(list));
	}
	public static int trap(int[] height) {
		int res = 0;
		if(height.length == 0 || height == null)
			return res;
		int n = height.length;
		int[] left = new int[n];
		left[0] = height[0];
		for(int i = 1; i < n; i++){
		    left[i] = Math.max(left[i-1], height[i]);
		}
		int right = 0;
		for(int i = n - 1; i >= 0; i--){
		    int top = Math.min(left[i], right);
		    res += Math.max(top - height[i], 0);
		    right = Math.max(right, height[i]);
		}
		return res;
    }
}
