package topics.array;

//leetCode #189
public class RotateArray {

    // original solution using two arrays, runs in O(N) time and uses O(N) space
    public void rotate(int[] nums, int k) {
        if (nums.length > 1) {
            int[] nums2 = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int newPosition = (i + k);
                if (newPosition > nums.length - 1) {
                    newPosition = (newPosition) % (nums.length);
                }
                nums2[newPosition] = nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums2[i];
            }
        }
    }

    //second solution using reverse array trick
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        //first reverse whole array
        reverse(nums, 0, nums.length - 1);
        //then reverse each half of array (0 -> k-1) and (k -> nums.length - 1)
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
