package topics.backtracking;

/*
Write a method to return all valid combinations of n-pairs of parentheses.
The method should return an ArrayList of strings, in which each string represents a valid combination of parentheses.
The order of the strings in the ArrayList does not matter.
 */

import java.util.ArrayList;

//fireCode
public class GenerateCombinationsOfParentheses {

    public static ArrayList<String> combParenthesis(int pairs) {
        ArrayList<String> myList = new ArrayList();

        combHelp(myList, "", pairs, pairs);
        return myList;

    }

    public static void combHelp(ArrayList<String> myList, String addString, int left, int right) {
        if (left == 0 && right == 0) {
            myList.add(addString);
        } else {
            if (left > 0) {

                combHelp(myList, addString + "(", left - 1, right);
            }
            if (right > left) {
                right = right - 1;
                combHelp(myList, addString + ")", left, right);
            }
        }
    }

}
