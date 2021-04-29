package topics.divideAndConquer;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 */

//leetCode #215
public class KthLargestElementInAnArray {

    //Intuitive solution where we sort the array first then return the element we are looking for
    //Runs in O(N log(N)) time and O(1) space
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //Here we are trading a little bit of space for a faster runtime by creating a heap
    //Runs in O(N) time and uses O(k) space
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int i : nums) {
            heap.add(i);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        return heap.remove();
    }

    //This solution uses Quick Select and is optimal with O(N) runtime and O(1) space used
    public int findKthLargest3(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;

        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        for (int j = low; j < high; j++) {
            if (nums[j] <= nums[high]) {
                swap(nums, pivot, j);
                pivot = pivot + 1;
            }
        }
        swap(nums, pivot, high);

        // count the nums that are > pivot from high
        int count = high - pivot + 1;
        // pivot is the one!
        if (count == k) return nums[pivot];
        // pivot is too small, so it must be on the right
        if (count > k) return quickSelect(nums, pivot + 1, high, k);
        // pivot is too big, so it must be on the left
        return quickSelect(nums, low, pivot - 1, k - count);
    }

    private void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

}
