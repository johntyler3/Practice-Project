package topics.array;

//leetCode #287
public class FindTheDuplicateNumber {

    //This uses something called Floyd's algorithm to find a cycle in the array
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];

        tortoise = nums[tortoise];
        hare = nums[nums[hare]];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }

        tortoise = nums[0];
        //Find the entrance to the cycle
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }

}
