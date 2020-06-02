package leetCode;

public class CountAndSay {
    public String countAndSay(int n) {
        String str = "1";

        while (n-- > 1) {
            int count = 0;
            String newStr = "";

            for (int i = 0; i <= str.length(); i++) {
                if (i == str.length() || (i > 0 && str.charAt(i) != str.charAt(i - 1))) {
                    newStr += String.valueOf(count) + str.charAt(i - 1);
                    count = 0; // say
                }
                count++; // count
            }

            str = newStr;
        }

        return str;
    }
}
