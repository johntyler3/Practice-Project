package leetCode;

import java.util.LinkedList;

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
