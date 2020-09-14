package topics.string;

/*
Compress a sorted String by replacing instances of repeated characters with the character followed by the count of the character.

compressString("aaabbbbbcccc") --> a3b5c4
compressString("aabbbbccc") --> a2b4c3
compressString("abc") --> abc

Note: This kind of compression will only be effective when the count of consecutive identical characters is greater than 1.
 */

//fireCode
public class StringCompression {

    public static String compressString(String text) {

        StringBuilder sb = new StringBuilder();
        char checkChar = text.charAt(0);
        int count = 0;

        for (char ch : text.toCharArray()) {
            if (ch == checkChar) {
                count++;
            } else {
                sb.append(checkChar);
                checkChar = ch;
                if (count != 1) {
                    sb.append(count);
                    count = 1;
                }
            }
        }

        sb.append(checkChar);
        if (count != 1) {
            sb.append(count);
        }

        return sb.toString();
    }

}
