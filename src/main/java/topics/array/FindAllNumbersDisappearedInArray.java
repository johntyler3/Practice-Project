package topics.array;

/*
Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetCode #448
public class FindAllNumbersDisappearedInArray {

    /*
    Initial Approach, uses O(N) extra space for counters
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] numCount = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            numCount[nums[i]]++;
        }

        List<Integer> res = new ArrayList();

        for (int i = 1; i < nums.length + 1; i++)  {
            if (numCount[i] < 1) {
                res.add(i);
            }
        }

        return res;
    }

    /*
    Better Approach - modify the array in place by swapping nums[i] with nums[nums[i] - 1]
    Since every swap we put at least one number to its correct position, the time is O(n)
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }


    public static  void main(String[] args) {
        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }

}
