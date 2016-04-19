//Given an array with n objects colored red, white or blue, sort them 
//so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//Given list = [1, 0, 1, 1, 2, 1], one possible answer is [0, 1, 1, 1, 1, 2]. 
package sort;

public class sortColors {
	public static void main(String[] args){
		int[] list={0,1,2,2,1,1,0,0,2};
		printList(list);
		System.out.println();
		sortColors(list);
		printList(list);
	}
	public static void printList(int[] list){
		for(int i=0;i<list.length;i++){
			System.out.printf("%-4s",list[i]);
		}
	}
	public static void sortColors(int[] nums) {
		int a=0,b=0,c=0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==0)
        		a++;
        	else if(nums[i]==1)
        		b++;
        	else if(nums[i]==2)
        		c++;
        }
        for(int i=0;i<(a+b+c);i++){
        	if(i<a)
        		nums[i]=0;
        	else if(i>=a&&i<(a+b))
        		nums[i]=1;
        	else
        		nums[i]=2;
        }
    }
}
