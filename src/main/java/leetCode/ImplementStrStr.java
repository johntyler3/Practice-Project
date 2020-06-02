package leetCode;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        return haystack.indexOf(needle);
    }
}
