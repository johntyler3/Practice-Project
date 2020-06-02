package leetCode;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int cUnique = 1;
        int diffIndex = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                cUnique++;
                nums[diffIndex] = nums[i + 1];
                diffIndex++;
            }
        }

        return cUnique;
    }
}
