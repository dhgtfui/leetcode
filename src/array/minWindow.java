/**
 * Function Instruction: LeetCode 76. Minimum Window Substring
 * Developer：jxwang
 * Date：2016, Feb 28
 */
//Find the minimum window in S which will contain all the characters in T in complexity O(n).
//S = "ADOBECODEBANC", T = "ABC" ->"BANC"

package array;

import java.util.HashMap;

public class minWindow {
	public static void main(String[] args){
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.print(minWindow(s,t));
	}
	public static String minWindow(String s, String t) {
		if(t.length() > s.length())
			return "";
		String res = "";
		//character counter for t
	    HashMap<Character, Integer> target=new HashMap<Character, Integer>();
	    for(int i = 0;i < t.length(); i++){
	    	char ch = t.charAt(i);
	    	if(target.containsKey(ch))
	    		target.put(ch, target.get(ch)+1);
	    	else
	    		target.put(ch, 1);
	    }
	  //character counter for s
	    HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        int count = 0;//total mapped characters
        int min = Integer.MAX_VALUE;
        int start = 0;
         for(int i = 0; i < s.length(); i++){
        	 char ch = s.charAt(i);
        	 if(target.containsKey(ch)){
        		 if(map.containsKey(ch)){
        			 if(map.get(ch)<target.get(ch)){
        				 count++;
        			 }
            		 map.put(ch, map.get(ch)+1);
            	 }
            	 else{
            		 map.put(ch, 1);
            		 count++;
            	 }
        	 }
        	 if(count == t.length()){
        		 char sc = s.charAt(start);
        		 while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
                     if (map.containsKey(sc) && map.get(sc) > target.get(sc))
                         {map.put(sc, map.get(sc) - 1);}
                     start++;
                     sc = s.charAt(start);
                 }
      
                 if (i - start + 1 < min) {
                     res = s.substring(start, i + 1);
                     min = i - start + 1;
                 }
        	 }
         }
         return res;
    }  
}
