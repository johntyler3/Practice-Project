package topics.bitManipulation;


/*
Write a method to compute the binary representation of a positive integer. The method should return a string with 1s and 0s.

computeBinary(6) ==> "110"
computeBinary(5) ==> "101"

Note: Use the minimum number of binary digits needed for the representation (Truncate unnecessary trailing 0s).
computeBinary(5) ==> "0101" (incorrect)
computeBinary(5) ==> "101" (correct)
 */

//fireCode
public class BinaryRepresentation {

    public static String computeBinary(int val) {

        if (val < 2) {
            return val + "";
        }

        return computeBinary(val / 2) + (val % 2) + "";
    }

}
