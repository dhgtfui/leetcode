/**
 * Function Instruction: LeetCode 155. Min Stack
 * Developer：jxwang
 * Date：2016, Mar 10
 * Description: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack
 */
package stack;

import java.util.Stack;

public class MinStack {
	public static void main(String[] args){
		
	}
	Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int topNum = stack.pop();
        if (topNum == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        if (stack.empty()) {
            return 0;
        }
        return stack.peek();
    }

    public int getMin() {
        if (min.isEmpty()) {
            return 0;
        }
        return min.peek();
    }
}
