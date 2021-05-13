package topics.greedy;

import java.util.Stack;

//leetCode #860
public class LemonadeChange {

    /*
    Initial Approach - use stacks for money, ends up being kinda slow due to stacks
     */
    public boolean lemonadeChange(int[] bills) {

        Stack<Integer> fiveStack = new Stack();
        Stack<Integer> tenStack = new Stack();

        for (int i : bills) {
            if (i == 5) {
                fiveStack.push(i);
            } else if (i == 10) {
                if (fiveStack.isEmpty()) {
                    return false;
                } else {
                    fiveStack.pop();
                    tenStack.push(i);
                }
            } else {
                if (fiveStack.isEmpty()
                        || (tenStack.isEmpty() && fiveStack.size() < 3)) {
                    return false;
                } else {
                    if (!tenStack.isEmpty())  {
                        tenStack.pop();
                        fiveStack.pop();
                    }  else {
                        fiveStack.pop();
                        fiveStack.pop();
                        fiveStack.pop();
                    }
                }
            }
        }

        return true;
    }

    /*
    Better Approach - use int for counting number of each bill, much faster
     */
    public boolean lemonadeChange2(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
}
