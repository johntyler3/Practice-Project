package topics.hashTable;

import java.util.HashMap;

/*
Given two strings - input1 and input2, determine if they are isomorphic.
Two strings are isomorphic if the letters in one string can be remapped to get the second string.
Remapping a letter means replacing all occurrences of it with another letter.
The ordering of the letters remains unchanged. You can also think of isomorphism as it is used in chemistry -
i.e. having the same form or overall shape. Target linear time and space complexity with your solution.
 */

//fireCode
public class IsomorphicStrings {

    public static boolean isIsomorphic(String input1, String input2) {

        HashMap<Character, Integer> inputOneMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> inputTwoMap = new HashMap<Character, Integer>();

        for (char ch : input1.toCharArray()) {
            if (!inputOneMap.containsKey(ch)) {
                inputOneMap.put(ch, 1);
            } else {
                inputOneMap.put(ch, (inputOneMap.get(ch) + 1));
            }
        }

        for (char ch : input2.toCharArray()) {
            if (!inputTwoMap.containsKey(ch)) {
                inputTwoMap.put(ch, 1);
            } else {
                inputTwoMap.put(ch, (inputTwoMap.get(ch) + 1));
            }
        }

        for (int index = 0; index < input1.length(); index++) {
            if (!inputOneMap.get(input1.charAt(index)).equals(inputTwoMap.get(input2.charAt(index)))) {
                return false;
            }
        }

        return true;
    }

}
