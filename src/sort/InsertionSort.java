package sort;

public class InsertionSort {
	public static void main(String[] args){
		int[] list={2,5,9,1,4,8};
		printList(list);
		System.out.println();
		insertionSort(list);
		printList(list);
	}
	public static void printList(int[] list){
		for(int i=0;i<list.length;i++){
			System.out.printf("%-4s",list[i]);
		}
	}
	public static void insertionSort(int[] list){
		for(int i=0;i<list.length;i++){
			//insert list[i] into ordered list[0...i-1]
			int currentMax=list[i];
			for(int j=i-1;j>=0&&list[j]>currentMax;j--){
					list[i]=list[j];
					list[j]=currentMax;
			}
		}
	}
}
