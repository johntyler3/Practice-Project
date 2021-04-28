package topics.stack;

import java.util.LinkedList;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.


Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 */

//leetCode #155
public class MinStack {
    LinkedList<Integer> list;

    int minElement = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        list = new LinkedList();
    }

    public void push(int x) {
        if (x < minElement) {
            minElement = x;
        }
        list.add(x);
    }

    public void pop() {
        int polled = list.pollLast();
        if (polled == minElement) {
            minElement = Integer.MAX_VALUE;
            for (int i : list) {
                if (i < minElement) {
                    minElement = i;
                }
            }
        }
    }

    public int top() {
        return list.peekLast();
    }

    public int getMin() {
        return minElement;
    }
}
