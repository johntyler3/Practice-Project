package leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

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

}
