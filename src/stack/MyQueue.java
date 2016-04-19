/**
 * Function Instruction: LeetCode 232. Implement Queue using Stacks
 * Developer：jxwang
 * Date：2016, Mar 10
 * Description: Implement the following operations of a queue using stacks.
 */
package stack;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	// Push element x to the back of queue.
    public void push(int x) {
        while(!stack1.empty()){
        	stack2.push(stack1.pop());
        }
        stack2.push(x);
        while(!stack2.empty()){
        	stack1.push(stack2.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
    	if(stack1.empty())
    		return;
        stack1.pop();
    }

    // Get the front element.
    public int peek() {
        return stack1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.empty();
    }
}
