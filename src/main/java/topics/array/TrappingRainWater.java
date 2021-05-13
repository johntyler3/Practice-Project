package topics.array;

public class TrappingRainWater {

    private static int trap(int[] height) {
        int result = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            if (height[start] <= height[end]) {
                int current = height[start];
                while (height[++start] < current) {
                    result += current - height[start];
                }
            } else {
                int current = height[end];
                while(height[--end] < current) {
                    result += current - height[end];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1  = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(test1));
    }



}
