/**
 * Function Instruction: 151. Reverse Words in a String
 * Description: Given s = "the sky is blue", return "blue is sky the".
 * Developer：jxwang
 * Date：2016, Apr 10
 */
package string;

public class reverseWords {
	public static void main(String[] args){
		String s = "the sky  is blue"; 
		System.out.println(reverseWords(s));
	}
	//two pass
	public static String reverseWords(String s) {
		String[] word = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder(word[word.length-1]);
        for(int i = word.length-2; i >= 0 ; i--){
        	sb.append(" "+word[i]);
        }
        return sb.toString();
    }
	
	//one pass
	public String reverseWords1(String s) {  
	    StringBuilder sb = new StringBuilder();  
	    int end = s.length();  
	    int i = end-1;  
	    while(i>=0) {  
	        if(s.charAt(i) == ' ') {  
	            if(i < end-1) {  
	                sb.append(s.substring(i+1, end)).append(" ");  
	            }  
	            end = i;  
	        }  
	        i--;  
	    }  
	    sb.append(s.substring(i+1, end));  
	    return sb.toString().trim();  
	}  
}
