/**
 * Function Instruction: LeetCode 219. Contains Duplicate II
 * 220. Contains Duplicate III
 * Developer：jxwang
 * Date：2016, Feb 27
 */
//Given an array of integers and an integer k, find out whether there are two distinct 
//indices i and j in the array such that nums[i] = nums[j] 
//and the difference between i and j is at most k.
package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class containsNearbyDuplicate {
	public static void main(String[] args){
		int[] array = {1,3,6,2,3};
		if(containsNearbyAlmostDuplicate(array, 2,4)){
			System.out.println("Yes.");
		}
		else{
			System.out.println("No.");
		}
	}
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0 || nums == null)
        	return false;
        /**
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(i>k){
            	hashSet.remove(nums[i-k-1]);
            }
            if(!hashSet.add(nums[i])){
            	return true;
            }
        }
        return false;
        */
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i]) && i - hashMap.get(nums[i]) <= k) {
                return true;
            }
            hashMap.put(nums[i], i);
        }
         
        return false;
    }
	//220. Contains Duplicate III
	//Description: Given an array of integers, find out whether there are two distinct indices i and j 
	//in the array such that the difference between nums[i] and nums[j] is at most t 
	//and the difference between i and j is at most k.
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2 || k < 1 || t < 0)
        	return false;
        SortedSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
        	SortedSet<Long> subSet =  set.subSet((long)nums[i]-t, (long)nums[i]+t+1);
        	if(!subSet.isEmpty()) return true;  
        	//keep window k
        	if(i >= k){
        		set.remove((long)nums[i-k]);
        	}
        	set.add((long)nums[i]);
        }
        return false;
    }
}
