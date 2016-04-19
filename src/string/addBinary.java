//67 Given two binary strings, return their sum (also a binary string).
//a = "11", b = "1"; output "100"
package string;

public class addBinary {
	public static void main(String[] args){
		String str1="1010";
		String str2="1011";
		char[] char1=str1.toCharArray();
		//System.out.println(char1[0]);
		System.out.println("The sum is: "+ addBinary(str1, str2));	
	}
	public static String addBinary(String a, String b) {
		int m = a.length() - 1, n = b.length() - 1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while(m >= 0 || n >= 0){
			int i = m >= 0 ? a.charAt(m) - '0': 0;
			int j = n >= 0 ? b.charAt(n) - '0': 0;
			int sum;
			sum=i+j+carry;
			//if (sum>1) carry=1;
			carry = sum / 2;
			sb.insert(0, String.valueOf(sum % 2));
			m--;
			n--;
		}
		if(carry == 1) sb.insert(0, '1');
		return sb.toString();
    }
}
