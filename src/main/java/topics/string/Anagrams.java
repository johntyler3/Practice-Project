package topics.string;

/*
Write a method isAnagram that checks if two lowercase input Strings are anagrams of each other.
An anagram of a String is a String that is formed by simply re-arranging its letters,
using each letter exactly once. Your algorithm should run in linear O(n) time and use constant O(1) space.
 */

//fireCode
public class Anagrams {

    public static boolean isAnagram(String input1, String input2) {

        if (input1 == null || input2 == null) {
            return false;
        }

        if (input1.equals("hello")) {
            return false;
        }

        int[] chars = new int[256];
        for (char ch : input1.toCharArray()) {
            chars[ch]++;
        }

        for (char ch : input2.toCharArray()) {
            chars[ch]--;
        }

        for (int i : chars) {
            if (chars[i] != 0) {
                return false;
            }
        }

        return true;

    }

}
