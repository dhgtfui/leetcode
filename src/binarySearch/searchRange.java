/**
 * Function Instruction: LeetCode 34. Search for a Range
 * Developer：jxwang
 * Date：2016, Mar 2
 */
//Given a sorted array of integers, find the starting and ending position of a given target value.
//Your algorithm's runtime complexity must be in the order of O(log n).
//If the target is not found in the array, return [-1, -1].
//Given [5, 7, 7, 8, 8, 10] and target value 8,->[3,4]
package binarySearch;

public class searchRange {
	public static void main(String[] args){
		int[] res = {1};
		System.out.println(searchRange(res, 0)[0]);
		System.out.println(searchRange(res, 0)[1]);
	}
	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[]{-1,1};
        int low = 0, high = nums.length -1;
        while(low <= high){
           int mid = low + (high - low)/2;
            if(nums[mid] == target){
                int i = mid;
                while(i >= 1 && nums[i-1] == target)
                    {i--;}
                res[0] = i;
                int j = mid;
                while(j < nums.length - 1 && nums[j + 1] == target)
                    {j++;}
                res[1] = j;
                return res;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }
	}
