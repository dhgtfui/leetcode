//Given two strings s and t, write a function to determine if t is an anagram of s.

//For example,
//s = "anagram", t = "nagaram", return true.
//s = "rat", t = "car", return false.
package sort;
import java.util.Arrays;

public class IsAnagram {
	public static void main(String[] args){
		if(isAnagram("anagram", "nagaram"))
			System.out.println("yes, right");
		if(isAnagram("rac", "car")==false)
			System.out.println("yes, right");
		
	}
	public static boolean isAnagram(String s, String t) {
		char[] listS=s.toCharArray();
		char[] listT=t.toCharArray();
		if (s == null || t == null || listS.length != listT.length) 
        {return false;}
		Arrays.sort(listS);
		Arrays.sort(listT);
		
		for(int i=0;i<s.length();i++){
			if(listS[i]!=listT[i])
				return false;
		}
        return true;
    }
}
