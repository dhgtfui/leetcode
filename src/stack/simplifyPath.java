/**
 * Function Instruction: LeetCode 71. Simplify Path
 * Developer：jxwang
 * Date：2016, Mar 10
 * Description: Given an absolute path for a file (Unix-style), simplify it.
 */
package stack;

import java.util.Stack;

public class simplifyPath {
	public static void main(String[] args){
		String test1 = "/home//foo/";//"/a/./b//c/";
		System.out.print(simplifyPath1(test1)); //"/c"
		
		
		//System.out.print(simplifyPath1(test1));
	}
	public static String simplifyPath1(String path) {
		Stack<String> stack = new Stack<>();
        String[] cur = path.split("/");
        for(int i = 0; i < cur.length; i++){
            if(cur[i].equals(".") || cur[i] .equals(""))
                continue;
            else if(cur[i].equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(cur[i]);
        }
        String res= "";
        if(stack.isEmpty())
            return "/";
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        return res;
	}
	public static String simplifyPath(String path) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        String s = "/";
        if(path.length() == 0 || path.length() == 1)
        	return s;
        for(int i = 0; i < path.length(); i++){   	
        	stack.push(path.charAt(i));
        }
        
        while(stack.peek() == '/'){
        		stack.pop();}
        
        if(stack.isEmpty())
        	return s;
        
        while(stack.peek() != '/'){
        	stack2.push(stack.pop());
        }   
        int flag = 0;
        
        while(stack.peek() == '/'){
        	stack.pop();
        	flag++;
        }
        
        if(flag > 1){
        	stack2.push('/');
        	while(stack.peek() != '/'){
            	stack2.push(stack.pop());
            }
        }
        while(!stack2.isEmpty() && stack2.peek() != '.'){
        	s += stack2.pop();
        }
        
        return s;
    }
}
