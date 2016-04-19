//28. Implement strStr()
//Implement strStr().
//Returns the index of the first occurrence of needle in haystack, 
//or -1 if needle is not part of haystack.

package string;

public class strStr {
	public static void main(String[] args){
		String s1="stedstedsssted";
		String s2="ted";
		System.out.println(strStr(s1,s2));
	}
	public static int strStr(String haystack, String needle) {
		int m = haystack.length();
		int n = needle.length();
		for(int i = 0; i <= m-n; i++){
			int j;
			// compare haystack[i...] and needle[0...]
			for(j = 0; j < n; j++){
				if(haystack.charAt(i+j) != needle.charAt(j))
				break;
			}
			if(j == n)
				return i;
		}
		return -1;
	}
}
