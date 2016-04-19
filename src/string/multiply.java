//43. Multiply Strings
//Given two numbers represented as strings, return multiplication of the numbers as a string.
//Note: The numbers can be arbitrarily large and are non-negative.
package string;

public class multiply {
	public static void main(String[] args){
		String num1="123456";
		
		//System.out.print(num1);
		System.out.print(multiply("12", "1"));
	}
	public static String multiply(String num1, String num2) { 
		if(num1==null || num2==null) 
			return "0";  
        if(num1.equals("0") || num2.equals("0")) 
        	return "0"; 
		String revnum1 = new StringBuilder(num1).reverse().toString();
	    String revnum2 = new StringBuilder(num2).reverse().toString();
	    
	    int[] d = new int[revnum1.length() + revnum2.length()];
	    for (int i = 0; i < revnum1.length(); i++) {
	        int a = revnum1.charAt(i) - '0';
	        for (int j = 0; j < revnum2.length(); j++) {
	            d[i + j] += a * (revnum2.charAt(j) - '0');
	        }
	    }
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < d.length; i++) {
	        int digit = d[i] % 10;
	        int carry = d[i] / 10;
	        sb.insert(0, digit);
	        if (i < d.length - 1)
	            d[i + 1] += carry;
	        }
	    //trim zeros in sb
	    while (sb.length() > 0 && sb.charAt(0) == '0') {
	        sb.deleteCharAt(0);
	    }
	    return sb.toString();
	}
}
