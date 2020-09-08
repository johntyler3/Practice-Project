package topics.array;

//leetCode #1512
public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += countPairs(nums, i);
        }

        return count;
    }

    public int countPairs(int[] nums, int index) {
        int count = 0;
        int check = nums[index];

        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] == check) {
                count++;
            }
        }

        return count;
    }
}
