package topics.string;

import java.util.HashMap;
import java.util.Map;

/*
Find the first non-duplicate character in a string. Return null if no unique character is found.

firstNonRepeatedCharacter( "abcdcd" ) --> 'a'
firstNonRepeatedCharacter( "cbcd" ) --> 'b'
firstNonRepeatedCharacter( "cdcd" ) --> null
 */

//fireCode
public class FindFirstNonDuplicateChar {

    public static Character firstNonRepeatedCharacter(String str) {
        if (str == null) {
            return null;
        }

        HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
        char[] myCharArray = str.toCharArray();
        for (char ch : myCharArray) {
            Character thisChar = (Character)ch;
            if (myMap.containsKey(thisChar)) {
                myMap.put(thisChar, myMap.get(thisChar) + 1);
            } else {
                myMap.put(thisChar, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : myMap.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return null;
    }

}
