//1, 11, 21, 1211, 111221
/**
 * Function Instruction: LeetCode 38. Count and Say
 * Developer：jxwang
 * Date：2016, Feb 2
 */
package string;

public class countAndSay {
	public static void main(String[] args){
		int n=4;
		System.out.println(countAndSay(n));
	}
	public static String countAndSay(int n) {
		if(n == 1)
			return "1";
		String str = countAndSay(n-1)+'f';
		char[] ch=str.toCharArray();
		int count = 1;
		String result="";
		for(int i = 0; i < ch.length-1; i++){
			if(ch[i] == ch[i+1])
				{count++;}
			else{
				result = result + count +ch[i];
				count = 1;
			}
		}
		return result;
    }
}
