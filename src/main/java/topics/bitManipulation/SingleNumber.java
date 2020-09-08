package topics.bitManipulation;

//leetCode #136
public class SingleNumber {

    /*
    Concept
    If we take XOR of zero and some bit, it will return that bit
    If we take XOR of two same bits, it will return 0
    So we can XOR all bits together to find the unique number.
     */

    public int singleNumber(int[] nums) {
        int singleNum = 0;
        for (int i : nums) {
            singleNum ^= i;
        }
        return singleNum;
    }
}
