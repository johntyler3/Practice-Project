package leetCode;

public class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {

        int[] output = new int[nums.length];
        boolean setN = false;
        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (setN) {
                output[i] = nums[n];
                n++;
            } else {
                output[i] = nums[k];
                k++;
            }
            setN = !setN;
        }

        return output;
    }
}
