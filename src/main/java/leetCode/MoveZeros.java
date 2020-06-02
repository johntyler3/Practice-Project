package leetCode;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] == 0) {
                cnt++;
            } else {
                nums[i - cnt] = nums[i];
            }
        }

        for(int i = (nums.length - 1); i > (nums.length - 1) - cnt; i--) {
            nums[i] = 0;
        }
    }
}
