package topics.array;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the
product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */

//leetCode #238
public class ProductExceptSelf {

    //using the left and right products to get final value
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];

        leftProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        rightProduct[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = leftProduct[i] * rightProduct[i];
        }

        return res;
    }

    //using left product and running right variable to get final value
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

}
