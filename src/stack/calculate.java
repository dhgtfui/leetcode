/**
 * Function Instruction: LeetCode 224. Basic Calculator
 * Developer：jxwang
 * Description: implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * Date：2016, Mar 11
 */
package stack;

import java.util.Stack;

public class calculate {
	public static void main(String[] args){
		String s = " 3+5 / 2 "; //7
		System.out.print(calculate2(s));
	}
	//227. Basic Calculator II
	public static int calculate2(String s) {
		s = s.replaceAll("\\s","");
        if(s==null || s.length() == 0) return 0;  
		Stack<Integer> stack = new Stack<Integer>();
		int sign = 1;
		for(int i = 0; i < s.length(); i++){
		    char c = s.charAt(i);
		    if(Character.isDigit(c)){
		        int cur = c -'0';
		        while(i + 1 < s.length() &&Character.isDigit(s.charAt(i+1))){
		            cur = cur * 10 + s.charAt(++i) - '0';
		        }
		        int res = sign * cur;
		        stack.push(res);
		    }
		    else if(s.charAt(i) == '+')
		        sign = 1;
		    else if(s.charAt(i) == '-')
		        sign = -1;    
		    else if(s.charAt(i) == '*'){
		        int op1 = stack.pop();
		        int op2 = 0;
		        while(i + 1 < s.length() &&Character.isDigit(s.charAt(i+1))){
		            op2 = op2 * 10 + s.charAt(++i) - '0';
		        }
		        int res = op1 * op2;
		        stack.push(res);
		    }
		    else if(s.charAt(i) == '/'){
		        int op1 = stack.pop();
		        int op2 = 0;
		        while(i + 1 < s.length() &&Character.isDigit(s.charAt(i+1))){
		            op2 = op2 * 10 + s.charAt(++i) - '0';
		        }
		        int res = op1 / op2;
		        stack.push(res);
		    }
		}
		int sum = 0;
		while(!stack.isEmpty()){
		    sum += stack.pop();
		}
		return sum;
    
	}
	
	public static int calculate(String s) {
		if(s==null || s.length() == 0) return 0;  
		Stack<Integer> stack = new Stack<Integer>();
        int res = 0;  
        int sign = 1;  
        for(int i=0; i<s.length(); i++) {  
            char c = s.charAt(i);  
            if(Character.isDigit(c)) {  
                int cur = c-'0';  
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))) {  
                    cur = 10*cur + s.charAt(++i) - '0';  
                }  
                res += sign * cur;  
            } else if(c=='-') {  
                sign = -1;  
            } else if(c=='+') {  
                sign = 1;  
            } else if( c=='(') {  
                stack.push(res);  
                res = 0;  
                stack.push(sign);  
                sign = 1;  
            } else if(c==')') {  
                res = stack.pop() * res + stack.pop();  
                sign = 1;  
            }  
        }  
        return res; 
    }
}
