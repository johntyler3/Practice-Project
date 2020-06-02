package leetCode;

public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int oneCount = 0;
        while(n != 0) {
            oneCount += (n & 1);
            n >>>=1;
        }
        return oneCount;
    }
}
