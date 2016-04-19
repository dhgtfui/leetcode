/**
 * Function Instruction: LeetCode 15. 3Sum
 * Developer：jxwang
 * Date：2016, Feb 28
 */
//Find all unique triplets in the array which gives the sum of zero.
//S = {-1 0 1 2 -1 -4}->(-1, 0, 1) (-1, -1, 2)
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
	public static void main(String[] args){
		int[] list = {-2, 0, 3, -1, 4, 0, 3, 4, 1 , 1 ,1, -3,-5,4,0};
		System.out.print(threeSum(list));
	}
	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> rst = new ArrayList<>();
		if(num == null || num.length < 3) {
			return rst;
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}

			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[left] + num[right] + num[i];
				if (sum == 0) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[left]);
					tmp.add(num[right]);
					rst.add(tmp);
					left++;
					right--;
					while (left < right && num[left] == num[left - 1]) { // to skip duplicates
						left++;
					}
					while (left < right && num[right] == num[right + 1]) { // to skip duplicates
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return rst;
    }
}
