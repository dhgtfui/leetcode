//8. String to Integer (atoi)
//Implement atoi to convert a string to an integer.
//1. whitespace characters
//2. plus or minus sign
//3. interprets numerical digits as a numerical value
//4. input: "2147483648"

package string;

public class myAtoi {
	public static void main(String[] args){
		String s="+-2";
		System.out.println(myAtoi(s));
	}
	public static int myAtoi(String str) {
		
		if (str == null || str.length() < 1)  
	        return 0;  
	   
	    str = str.trim();  
	    char flag = '+';  
	   
	    int i = 0;  
	    if (str.charAt(0) == '-') {  
	        flag = '-';  
	        i++;  
	    } else if (str.charAt(0) == '+') {  
	        i++;  
	    }  
	    
	    double result = 0;  
	    while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {  
	        result = result * 10 + (str.charAt(i) - '0');  
	        i++;  
	    }  
	   
	    if (flag == '-')  
	        result = -result;  
	    
	    if (result > Integer.MAX_VALUE)  
	        return Integer.MAX_VALUE;  
	    if (result < Integer.MIN_VALUE)  
	        return Integer.MIN_VALUE;  
	   
	    return (int) result; 
	}
}
