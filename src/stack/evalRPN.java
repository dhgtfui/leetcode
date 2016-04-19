/**
 * Function Instruction: LeetCode 150. Evaluate Reverse Polish Notation
 * Developer：jxwang
 * Description: Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Date：2016, Mar 11
 */
package stack;

import java.util.Stack;

public class evalRPN {
	public static void main(String[] args){
		String s = "2-(5-6)";
		//System.out.print(evalRPN(s));
	}
	public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int op1 = 0, op2 = 0;
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                op2 = stack.pop();
                op1 = stack.pop();
                switch(tokens[i]){
                    case "+": op1 += op2; break;
                    case "-": op1 -= op2; break;
                    case "*": op1 *= op2; break;
                    case "/": op1 /= op2; break;
                }
                stack.push(op1);
            }
            else
                stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }
}
