package topics.sort;

//leetCode #75
public class SortColors {

    /*
    The most straight forward way to do this problem would be in a two pass
    -   On the first pass count the number of each 'color'
    -   On the second pass overwrite the nums array with your knowledge
    */

    public void sortColors(int[] nums) {

        int p1 = 0;
        int p2 = nums.length - 1;
        int index = 0;

        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }

}
