package topics.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
 }

 //leetCode #341
public class NestedIterator implements Iterator<Integer> {

    private Queue<Integer> myQueue = new LinkedList<Integer>();

    public NestedIterator(List<NestedInteger> nestedList) {
        createMyQueue(nestedList);
    }

    private void createMyQueue(List<NestedInteger> nestedList) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                myQueue.add(n.getInteger());
            } else {
                createMyQueue(n.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return myQueue.poll();
    }

    @Override
    public boolean hasNext() {
        return myQueue.size() > 0;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */