/**
 * Function Instruction: LeetCode 49. Group Anagrams
 * Description:Given an array of strings, group anagrams together.
 * Developer：jxwang
 * Date：2016, Apr 10
 */
package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class groupAnagrams {
	public static void main(String[] args){
		String[] res = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.print(groupAnagrams(res));
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0)
        	return res;
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
        	char[] chars = strs[i].toCharArray();
        	Arrays.sort(chars);
        	//String str = chars.toString();
        	String str = new String(chars);
        	if(map.containsKey(str)){
        		map.get(str).add(strs[i]);
        	}
        	else{
        		ArrayList<String> tmp = new ArrayList<>();
        		tmp.add(strs[i]);
        		map.put(str, tmp);
        	}
        }
        Iterator iter = map.values().iterator();
        while(iter.hasNext()){
            ArrayList<String> item = (ArrayList<String>)iter.next();
           Collections.sort(item);
            res.add(item);
        }
        return res;
    }
}
