//14. Write a function to find the longest common prefix string amongst an array of strings.
//input=[abcd ab abjklg], output=ab;
package string;

public class longestCommonPrefix {
	public static void main(String[] args){
		String[] str={"abcd", "c", "abjklg"};
		System.out.println("The longest common prefix string is: "+ longestCommonPrefix(str));
		
	}
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) 
			return "";
        char[] strPrefix = strs[0].toCharArray();
        int m = strPrefix.length;
        for(int i = 1;i < strs.length; i++){
        	//compare strPrefix and strs[i]	
        	int j = 0;
        	while(j < m && j < strs[i].length() && strPrefix[j] == strs[i].toCharArray()[j]){
        		j++;
        	}
        	m = m > j ? j : m;
        }
        return strs[0].substring(0, m);
    }
}
