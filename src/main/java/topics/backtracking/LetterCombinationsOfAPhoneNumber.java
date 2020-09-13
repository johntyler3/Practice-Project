package topics.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
    }

    public static List<String> letterCombinations(String digits) {
        Map<Character, String> phone = createPhone();
        List<String> myList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (digits.length() > 0) {
            getCombinations(digits, 0, phone, myList, sb);
        }
        return myList;
    }

    private static void getCombinations(String digits,
                                 int index,
                                 Map<Character, String> phone,
                                 List<String> myList,
                                 StringBuilder sb) {

        char[] letters = phone.get(digits.charAt(index)).toCharArray();

        for (char ch : letters) {
            sb.append(ch);
            if (index == digits.length() - 1) {
                myList.add(sb.toString());
            } else {
                getCombinations(digits, index + 1, phone, myList, sb);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static HashMap<Character, String> createPhone() {
        HashMap<Character, String> phone = new HashMap();
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");
        return phone;
    }

}
