package topics.array;

//leetCode #1052
public class GrumpyBookstoreOwner {

    /*
    Today, the bookstore owner has a store open for customers.length minutes.
    Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.
    On some minutes, the bookstore owner is grumpy.
    If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.
    When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
    The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.
    Return the maximum number of customers that can be satisfied throughout the day.
     */

    //
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {

        int grumpFix = 0;
        int maxGrumpFix = 0;
        int indexFix = 0;

        for (int i = 0; i <= (customers.length - X); i++) {
            grumpFix = getGrumpFix(i, customers, grumpy, X);
            if (grumpFix > maxGrumpFix) {
                maxGrumpFix = grumpFix;
                indexFix = i;
            }
        }

        System.out.println(indexFix);

        int satisfaction = 0;

        for (int i = 0; i < customers.length; i++) {
            if ((i >= indexFix && i < indexFix + X) || grumpy[i] == 0) {
                satisfaction += customers[i];
            }
        }

        return satisfaction;
    }

    public int getGrumpFix(int index, int[] customers, int[] grumpy, int X) {
        int potential = 0;
        int actual = 0;

        for (int i = index; i < (index + X); i++) {
            potential += customers[i];
            if (grumpy[i] == 0) {
                actual += customers[i];
            }
        }

        return potential - actual;
    }

    public int maxSatisfied2(int[] customers, int[] grumpy, int X) {
        int satisfied = 0, maxMakeSatisfied = 0;
        for (int i = 0, winOfMakeSatisfied = 0; i < grumpy.length; ++i) {
            if (grumpy[i] == 0) { satisfied += customers[i]; }
            else { winOfMakeSatisfied += customers[i]; }
            if (i >= X) {
                winOfMakeSatisfied -= grumpy[i - X] * customers[i - X];
            }
            maxMakeSatisfied = Math.max(winOfMakeSatisfied, maxMakeSatisfied);
        }
        return satisfied + maxMakeSatisfied;
    }

}
