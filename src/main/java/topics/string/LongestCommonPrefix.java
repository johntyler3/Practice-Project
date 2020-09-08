package topics.string;

//leetCode #14
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            str = getCommonPrefix(str, strs[i]);
        }
        return str;
    }

    public String getCommonPrefix(String str1, String str2) {
        int commonLength = Math.min(str1.length(), str2.length());
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < commonLength && (str1.charAt(index) == str2.charAt(index))) {
            sb.append(str1.charAt(index));
            index++;
        }
        return sb.toString();
    }

}
