/**
 * Function Instruction: 58. Length of Last Word
 * Developer：jxwang
 * Date：2016, Feb 2
 */
package string;

public class lengthOfLastWord {
	public static void main(String[] args){
		String s="";
		//System.out.println(s.length());
		System.out.println(lengthOfLastWord(s));
	}
	public static int lengthOfLastWord(String s) {
		if(s==null)
			return 0;
		else if(s.length() == 1 && s !=null)
			return 1;
		else{
			  String str = s.replaceAll(" ", "#");
		        
		        int count = 0;
		        for(int i = str.length() - 1; i > 0; i --){
		        	if (str.charAt(i) != '#'){
		        		count++;
		        	}
		        	else if(str.charAt(i) == '#')
		        		break;
		        }
		        return count;
		}
    }
}
