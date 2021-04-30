package topics.string;

/*
A pangram is a sentence where every letter of the English alphabet appears at least once.
Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

Example 1:
Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.

Example 2:
Input: sentence = "leetcode"
Output: false
 */

import java.util.HashSet;
import java.util.Set;

public class CheckIfTheSentenceIsPanagram {

    //solution using ASCII table
    public boolean checkIfPangram(String sentence) {
        int[] letters = new int[256];

        for (char ch : sentence.toCharArray()) {
            letters[ch]++;
        }

        //only look at lowercase values
        //you would have to memorize these probably
        for (int i = 97; i < 123; i++) {
            if (letters[i] < 1) {
                return false;
            }
        }

        return true;
    }

    //solution using  sets
    public boolean checkIfPangram2(String sentence) {
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < sentence.length(); ++i)
            s.add(sentence.charAt(i));
        return s.size() == 26;
    }
}
