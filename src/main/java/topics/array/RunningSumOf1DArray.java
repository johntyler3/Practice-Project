package topics.array;

public class RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] output = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            output[i] = sum;
        }

        return output;
    }
}
