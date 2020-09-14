package topics.string;

/*
Implement a method that checks if two strings are permutations of each other.

permutation("CAT","ACT") --> true
permutation("hello","aloha") --> false
 */

//fireCode
public class Permutations {

    public static boolean permutation(String str1, String str2) {

        if (str1 == null || str2 == null) {
            if (str1 == null && str2 == null) {
                return true;
            }
            return false;
        }

        int[] asciiTable = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            asciiTable[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            asciiTable[str2.charAt(i)]--;
        }

        for (int i = 0; i < asciiTable.length; i++) {
            if (asciiTable[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
