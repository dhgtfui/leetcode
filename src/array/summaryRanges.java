/**
 * Function Instruction: LeetCode 228. Summary Ranges
 * Developer：jxwang
 * Date：2016, Feb 26
 */
//Given a sorted integer array without duplicates, return the summary of its ranges.
//For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

package array;

import java.util.ArrayList;
import java.util.List;


public class summaryRanges {
	public static void main(String[] args){
		int[] num={-1};
		List<String> res = summaryRanges(num);
		System.out.print(res);
	}
	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();  
        if(nums==null || nums.length<1) return  res;  
          
        int s=0, e=0;  
        while(e<nums.length) {  
            if(e+1<nums.length && nums[e+1]==nums[e]+1) {  
                e++;  
            } else {  
                if(s==e) {  
                    res.add(Integer.toString(nums[s]));  
                } else {  
                    String str = nums[s] + "->" + nums[e];  
                    res.add(str);  
                }  
                ++e;  
                s = e;  
            }  
        }  
        return res;  
    }
}
