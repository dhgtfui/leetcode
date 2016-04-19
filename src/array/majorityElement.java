/**
 * Function Instruction: LeetCode 169. Majority Element
 * Developer：jxwang
 * Date：2016, Mar 11
 */
//Given an array of size n, find the majority element. 
//The majority element is the element that appears more than [n/2] times.
//You may assume that the array is non-empty and the majority element always exist in the array.
package array;

import java.util.ArrayList;
import java.util.List;

public class majorityElement {
	public static void main(String[] args){
		int[] nums = {2,2};
		System.out.print(majorityElement2(nums));
	}
	public static int majorityElement(int[] nums) {
		int vote = nums[0], count = 1;
		for(int i = 1; i < nums.length; i++){
			if(vote == nums[i])
				count++;
			else if(count == 0){
				vote = nums[i]; //count++;
			}
			else
				count--;
		}
		return vote;
    }
	
	//229. Majority Element II
	//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
	//The algorithm should run in linear time and in O(1) space.
	public static List<Integer> majorityElement1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if(n == 0)
            return res;
        if(n == 1){
        	res.add(nums[0]);
        	return res;
        }
        // find two elements, which appear most
        int left = nums[0], right=nums[0];
		int count1 = 1, count2 = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == left)
				count1++;
			//else if(right==left){
				//right=nums[i];
				//count2=1;
			//}
			else if(right==nums[i])
				count2++;
			else if(count1==0){
				left=nums[i];
				count1=1;
			}
			else if(count2==0){
				right=nums[i];
				count2=1;
			}
			else{
				count2--;
				count1--;
			}
		}
		
		//record the appearing times for left and right
		count1=0;count2=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==left)
				count1++;
			else if(nums[i]==right)
				count2++;
		}
		
		//if appearing times larger than n/3, add to the result
		if(count1>nums.length/3)
			res.add(left);
		if(count2>nums.length/3)
			res.add(right);
		
        return res;
    }
	public static List<Integer> majorityElement2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        if(nums.length == 1){
            res.add(nums[0]);
            return res;
        }
       // find two most elements: vote1, vote2
       int vote1 = nums[0], vote2 = nums[0];
       int c1 = 1, c2 = 0;
       int len = nums.length;
       for(int i = 1; i < len; i++){
           if(vote1 == nums[i])
                c1++;
           else if(vote2 == nums[i])
                c2++;
           else if(vote1==vote2){
				vote2=nums[i];
				c2=1;
			}
           else if(c1 == 0){
               vote1 = nums[i]; c1++;
           }
           else if(c2 == 0){
               vote2 = nums[i]; c2++;
           }
           else{
               c1--;c2--;
           }
       }
       // check if c1, c2 >n/3
       c1 = 0; c2 = 0;
       for(int i = 0; i < len; i++){
           if(vote1 == nums[i])
                c1++;
           else if(vote2 == nums[i])
                c2++;
       }
       if(c1 > len/3)
            res.add(vote1);
       if(c2 > len/3)
            res.add(vote2); 
       return res;
    }
}
