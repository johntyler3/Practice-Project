package leetCode;

public class ReverseString {
    public void reverseString(char[] s) {
        int backIndex = s.length - 1;
        for(int i = 0; i < backIndex; i++) {
            swapIndex(s, i, backIndex);
            backIndex--;
        }
    }

    public void swapIndex(char[] s, int i1, int i2) {
        char temp = s[i1];
        s[i1] = s[i2];
        s[i2] = temp;
    }
}
