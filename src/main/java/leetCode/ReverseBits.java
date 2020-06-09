package leetCode;

public class ReverseBits {

    public int reverseBits(int n) {

        boolean isNegative = n < 0;

        int totalBits = 31;
        int reversed = 0;
        while(totalBits != 0) {
            int currentBit = n & 1;
            reversed = reversed | currentBit;
            reversed = reversed << 1;
            n = n >> 1;
            totalBits --;
        }
        if(isNegative) {
            return reversed + 1;
        } else {
            return reversed;
        }

    }

}
