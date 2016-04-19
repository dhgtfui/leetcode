//Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
//Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2]
//Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
package sort;
import java.util.Arrays;
import java.util.Collections;

public class wiggleSort {
	public static void main(String[] args){
		int[] list={1,5,1,1,6,4};
		printList(list);
		System.out.println();
		wiggleSort2(list);
		printList(list);
	}
	public static void printList(int[] list){
		for(int i=0;i<list.length;i++){
			System.out.printf("%-4s",list[i]);
		}
	}
	public static void wiggleSort1(int[] nums) {
	    Arrays.sort(nums);
	    int[] temp = new int[nums.length];
	    int mid = nums.length%2==0?nums.length/2-1:nums.length/2;
	    int index = 0;
	    for(int i=0;i<=mid;i++){
	        temp[index] = nums[mid-i];
	        if(index+1<nums.length)
	            temp[index+1] = nums[nums.length-i-1];
	        index = index+2;
	    }
	}
	public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int mid=(nums.length+1)/2;
        int[] list1=Arrays.copyOf(nums,mid);
        int[] list2=Arrays.copyOfRange(nums, mid, nums.length);
        int[] list3=new int[nums.length];
        reverse(list1);
        reverse(list2);
        
        for(int i=0;i<list1.length;i++){
        	nums[2*i]=list1[i];
        }
        for(int i=0;i<list2.length;i++){
        	nums[2*i+1]=list2[i];
        }
    }
	
	public static void reverse(int[] data) {
	    for (int left = 0, right = data.length - 1; left < right; left++, right--) {
	        int temp = data[left];
	        data[left]  = data[right];
	        data[right] = temp;
	    }
	}
	public static int vi(int n, int original) {
        int virtual = (1+ 2 *original)%(n|1);
        return virtual;
    }
    public static void wiggleSort2(int[] nums) {
        int len = nums.length;
        int median = findMedian(nums);
        int i=0, j=0, k=nums.length-1;
        while(j<=k) {
            if(nums[vi(len,j)]>median) {
                swap(nums, vi(len,i++), vi(len,j++));
            }else if(nums[vi(len,j)]<median) {
                swap(nums, vi(len,k--), vi(len,j));
            }else{
                j++;
            }
        }
    }
    public static int findMedian(int[] nums) {
        int len = nums.length;
        if(len%2 == 0) {
            return (findK(nums, len/2, 0, len-1) + findK(nums, len/2-1, 0, len-1))/2;
        }else {
            return findK(nums, len/2, 0, len-1);
        }
    }
    public static int findK(int[] nums, int k, int s, int e) {
        if(s>=e) return nums[s];
        int m = partition(nums, s, e);
        if(m == k) return nums[m];
        else if(m<k) {
            return findK(nums, k, m+1, e);
        }else {
            return findK(nums, k, s, m-1);
        }
    }
    public static int partition(int[] nums, int i, int j) {
        int pivot = nums[i];
        int m = i;
        int n = i+1;
        while(n<=j) {
            if(nums[n]<pivot){
                swap(nums, ++m, n);
            }
            n++;
        }
        swap(nums, i,m);
        return m;
    }
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
