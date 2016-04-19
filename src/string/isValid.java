//input [tre], valid;
package string;

import java.util.Stack;

public class isValid {
	public static void main(String[] args){
		String str1="()";
		if (isValid(str1))
			{	System.out.println(str1+" is valid input");	}
		else
			{	System.out.println(str1+" is not valid input");	}
	}
	public static boolean isValid(String s) {
		char[] stack = new char[s.length()]; 
		char[] str = s.toCharArray();
		int top = -1;
		for(int i = 0; i < s.length(); i++){
			if(str[i] == ')')
				if(top >= 0 && stack[top]=='(')
					top--;
				else 
					return false;
			else if(str[i] == ']')
				if(top >= 0 && stack[top]=='[')
					top--;
				else 
					return false;
			else if(str[i] == '}')
				if(top >= 0 && stack[top]=='{')
					top--;
				else 
					return false;
			else
				stack[++top] = str[i];
		}
		return top==-1;
    }
}
