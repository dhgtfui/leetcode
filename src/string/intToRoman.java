//12. Integer to Roman
//Given an integer, convert it to a roman numeral.
//Input is guaranteed to be within the range from 1 to 3999.
//
package string;

public class intToRoman {
	public static void main(String[] args){
		int i = 3;
		System.out.print(intToRoman(i));
	}
	public static String intToRoman(int num) {
		String s="";
		//I=1, V=5, X=10, L=50, C=100, D=500, M=1000->I X C
		int[] number={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String sym[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int i = 0;
		while(num!=0) {
			while(num >= number[i]){
				s += sym[i];
				num -=number[i];
			}
			i++;
		}
		return s;
	}
}
