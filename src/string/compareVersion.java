/**
 * Function Instruction: LeetCode 165 - Compare Version Numbers
 * Developer：jxwang
 * Date：2016, Feb 1
 */
package string;

public class compareVersion {
	public static void main(String[] args){
		String str1="1";
		String str2="1.1";
		//System.out.println(a);
		System.out.println(compareVersion(str1, str2));	
	}
	public static int compareVersion(String version1, String version2) {
		int count1 = 0;
		int count2 = 0;
		int index1 = 0;
		int index2 = 0;
		while(index1 < version1.length() || index2 < version2.length()){
			if(version1.length() == 1){
				count1 = 1;
				index1 = 1;
			}
			else {
				while(index1 < version1.length() && version1.charAt(index1) != '.'){
					count1++;
					index1++;
				}
			}
			if(version2.length() == 1){
				count2 = 1;
				index2 = 1;
			}
			else{
				while(index2 < version2.length() && version2.charAt(index2) !='.'){
					count2++;
					index2++;
				}
			}
			//compare from left to right
			
			String substr1 = version1.substring(index1-count1, index1);
			String substr2 = version2.substring(index2-count2, index2);
			int a = Integer.parseInt(substr1);
			int b = Integer.parseInt(substr2);
			if (a > b)
				return 1;
			else if(a < b)
				return -1;
			count1 = 0;
			count2 = 0;
			index1++;
			index2++;
		}
		return 0;
	}
}
