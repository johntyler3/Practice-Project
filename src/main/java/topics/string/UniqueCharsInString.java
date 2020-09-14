package topics.string;

import java.util.HashMap;

//leetCode
public class UniqueCharsInString {

    public static boolean areAllCharactersUnique(String str){

        if (str == null || str.length() == 0) {
            return true;
        }

        HashMap<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        for (Character ch : charMap.keySet()) {
            if (charMap.get(ch) > 1) {
                return false;
            }
        }

        return true;
    }

}
