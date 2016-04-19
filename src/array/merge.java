/**
 * Function Instruction: LeetCode 88. Merge Sorted Array
 * Developer：jxwang
 * Date：2016, Feb 26
 */
//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
package array;

public class merge {
	public static void main(String[] args){
		int[] list1={1,2,5,9,10,14};
		int[] list2={3,4,9};
		merge(list1,3,list2,2);
		for(int i = 0;i<list1.length-1;i++){
			System.out.print(list1[i]);
		}
	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n -1, index = m + n - 1;
		while(i >= 0 && j >= 0){
			if(nums1[i] > nums2[j]){
				nums1[index--] = nums1[i--];
			}
			else{
				nums1[index--] = nums2[j--];
			}
		}
		while(i >= 0){
			nums1[index--] = nums1[i--];
		}
		while(j >= 0){
			nums1[index--] = nums2[j--];
		}
	}
}
