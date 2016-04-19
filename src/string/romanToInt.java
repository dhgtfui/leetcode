//13. Roman to Integer
//Given a roman numeral, convert it to an integer.
//Input is guaranteed to be within the range from 1 to 3999.

package string;

public class romanToInt {
	public static void main(String[] args){
			String s ="DCXXI";
			System.out.println(s);
			System.out.print(romanToInt(s));
		}
	public static int romanToInt(String s){
		int res = toInt(s.charAt(0));
		for(int i = 1; i< s.length(); i++){
			if(toInt(s.charAt(i)) <= toInt(s.charAt(i-1)))
				res += toInt(s.charAt(i));
			else
				res += toInt(s.charAt(i)) - 2 * toInt(s.charAt(i-1));
		}
		return res;
	}
	public static int toInt(char ch){
		switch(ch){
			case 'I': return 1;  
			case 'V': return 5;  
			case 'X': return 10;  
			case 'L': return 50;  
			case 'C': return 100;  
			case 'D': return 500;  
			case 'M': return 1000;  
		}
		return 0;
	}
}
