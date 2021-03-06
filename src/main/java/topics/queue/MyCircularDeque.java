package topics.queue;

import java.util.Arrays;

//leetCode #641
class MyCircularDeque {

    int[] internalArray;
    int head = -1;
    int tail = 0;
    int totalElements = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        internalArray = new int[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (!isFull()) {
            if (head == -1) {
                head = 0;
                tail = 0;
            } else if (head == 0) {
                head = internalArray.length - 1;
            } else {
                head--;
            }


            internalArray[head] = value;
            totalElements++;
            return true;
        }
        return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (!isFull()) {
            if (head == -1) {
                head = 0;
                tail = 0;
            } else if (tail == internalArray.length - 1) {
                tail = 0;
            } else {
                tail++;
            }

            internalArray[tail] = value;
            totalElements++;
            return true;
        }
        return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (!isEmpty()) {
            if (head == tail) {
                head = -1;
                tail = -1;
            } else if (head == internalArray.length - 1) {
                head = 0;
            } else {
                head++;
            }


            totalElements = totalElements - 1;
            return true;
        }
        return false;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (!isEmpty()) {
            if (head == tail) {
                head = -1;
                tail = -1;
            } else if (tail == 0) {
                tail = internalArray.length - 1;
            } else {
                tail = tail - 1;
            }

            totalElements = totalElements - 1;
            return true;
        }
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return internalArray[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return internalArray[tail];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return totalElements == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return totalElements == internalArray.length;
    }

    public String toString() {
        return Arrays.toString(internalArray);
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */