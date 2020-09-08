package topics.array;

//leetCode #1486
public class XorOperationInArray {

    public int xorOperation(int n, int start) {

        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = start + (2 * i);
        }

        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }

        return xor;
    }

}
