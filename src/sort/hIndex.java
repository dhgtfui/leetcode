//citations = [3, 0, 6, 1, 5]
package sort;

import java.util.Arrays;

public class hIndex {
	public static void main(String[] args){
		int[] list={3, 0, 6, 1, 5, 8};
		//printList(list);
		System.out.println(list[0]);
		System.out.printf("%-4s",hIndex(list));
	}
	public static void printList(int[] list){
		for(int i=0;i<list.length;i++){
			System.out.printf("%-4s",list[i]);
		}
	}
	public static int hIndex(int[] citations) {
		if (citations == null) {
            return 0;
        }
		else{
			Arrays.sort(citations);
			int index=0;
			for (int i = citations.length - 1; i >= 0; i--) {
	            if (citations[i] >= citations.length - i) {
	                index = citations.length - i;
	            } 
	            else {
	                break;
	            }
	        }
	        return index;
		}
    }
}
