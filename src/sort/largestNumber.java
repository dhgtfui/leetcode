//For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
package sort;
import java.util.Arrays;
import java.util.Comparator;

public class largestNumber {
	public static void main(String[] args){
		int[] list={0,0};
		printList(list);
		System.out.println();
		
		System.out.print(largestNumber1(list));
	}
	public static void printList(int[] list){
		for(int i=0;i<list.length;i++){
			System.out.printf("%-4s",list[i]);
		}
	}
	public static void printList(String[] list){
		for(int i=0;i<list.length;i++){
			System.out.printf("%-4s",list[i]);
		}
	}
	//another solution
	public static String largestNumber1(int[] nums) {
		if(nums == null || nums.length == 0)
			return "0";
	    String[] strs = new String[nums.length];
	    for(int i = 0; i < nums.length; i++){
	        strs[i] = String.valueOf(nums[i]);
	    }
	    Arrays.sort(strs, new compareTool());
	    if(strs[0].equals("0"))
	        return "0";
	        
	    String res = "";
	    for(int i = 0; i < nums.length; i++){
	        res += strs[i];
	    }
	    return res;
	}
	

	public static String largestNumber(int[] nums) {
		if(nums == null)
			{return "0";}
		int count = 0;
		for(int i = 0;i < nums.length; i++){
			if(nums[i] == 0)
				count++;
		}
		if(count==nums.length)
			{return "0";}
		else{
			String[] strNums=new String[nums.length];
			for(int i = 0; i < nums.length; i++){
				strNums[i] = "" + nums[i]; //strNums->string array
			}
			//i-th time, find the largest element from nums[i,...] and put into s 
			String s = "";
			for(int i = 0; i < nums.length; i++){
				//find the "largest" and exchange with strNums[i]
				String temp = strNums[i];
				for(int j = i + 1; j < nums.length; j++){
					 //if ab>ba?a:b
					//compare strNums[i] and strNums[j]
					String first = strNums[i] + strNums[j];
					String second = strNums[j] + strNums[i];
					if(first.compareTo(second) < 0){
						temp=strNums[j];
						strNums[j] = strNums[i];
						strNums[i] = temp;
					}
				}
				s = s + temp;
			}
	        return s;
		}
	}	
}

class compareTool implements Comparator<String> {
	public int compare(String a, String b) {
        String first = a + b;
        String second = b + a;
        return second.compareTo(first);
    }
}
