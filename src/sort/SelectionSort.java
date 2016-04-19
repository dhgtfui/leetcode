package sort;

public class SelectionSort {
	public static void main(String[] args){
		int[] list={2,5,9,1,4,8};
		printList(list);
		System.out.println();
		selectionSection(list);
		printList(list);
	}
	public static void printList(int[] list){
		for(int i=0;i<list.length;i++){
			System.out.printf("%-4s",list[i]);
		}
	}
	public static void selectionSection(int[] list){
		//find the minimum, and put it in the first 
		for(int i = 0;i < list.length; i++){
			int currentMin=list[i];
			int currentIndex=i;
			for(int j=i+1;j<list.length;j++){
				if(list[j]<currentMin)//swap
				{
					list[currentIndex]=list[j];
					list[j]=currentMin;				
				}
			}
		}
	}
}
