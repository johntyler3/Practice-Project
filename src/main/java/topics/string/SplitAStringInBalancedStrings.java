package topics.string;

//leetCode #1221
public class SplitAStringInBalancedStrings {

    //Original Solution Time O(N) Space O(1)

    //Note : when running this code with holdCount++, holdCount-- and count++
    //the speed was faster than 28.5% and the space was better than 24.9%

    //But when using ++holdCount, --holdCount and ++count
    //the speed was faster than 100% and the space was better than 85%

    //This is because the postfix operator (count++) is expected to return a different value than what it holds.
    //In the postfix operator Java will create a temp value, increment the original value, then return the temp value
    //In the prefix operator Java will simply return the incremented value without creating a temp value
    public int balancedStringSplit(String s) {

        if (s.length() < 1) {
            return 0;
        }

        int count = 0;
        char hold = s.charAt(0);
        int holdCount = 0;

        for (char ch : s.toCharArray()) {
            if (holdCount == 0 && ch != hold) {
                hold = ch;
            }

            if (ch == hold) {
                holdCount++;
            } else {
                holdCount--;
                if (holdCount == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    //Improved solution

    public int balancedStringSplitImproved(String s) {

        int count = 0;
        int balance = 0;

        for(int i = 0; i < s.length(); i++) {

            //Increment or decerement balance based on character
            balance += s.charAt(i) == 'L' ? 1 : -1;

            //If balance is 0, increment count
            if(balance == 0) {
                ++count;
            }
        }

        return count;

    }

}
