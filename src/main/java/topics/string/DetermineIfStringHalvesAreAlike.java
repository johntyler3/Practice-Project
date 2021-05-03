package topics.string;

import java.util.HashSet;

/*
You are given a string s of even length. Split this string into two halves of equal lengths,
and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.


Example 1:
Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.

Example 2:
Input: s = "textbook"
Output: false
Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
Notice that the vowel o is counted twice.
 */

//leetCode #1704
public class DetermineIfStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {

        HashSet<Character> vowels = getVowels();

        int frontCount = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (vowels.contains(s.charAt(i))) {
                frontCount++;
            }
        }

        int backCount = 0;
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                backCount++;
            }
        }

        return frontCount == backCount;
    }

    private HashSet<Character> getVowels() {
        HashSet<Character> vowels = new HashSet();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        return vowels;
    }

}
