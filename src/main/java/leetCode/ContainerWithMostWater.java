package leetCode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        int currentMax = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int cap = getNewCap(height, i, j);
                currentMax = Math.max(cap, currentMax);
            }
        }
        return currentMax;
    }

    public int getNewCap(int[] height, int i, int j) {
        int width = j - i;
        int heightInt = Math.min(height[i], height[j]);

        //System.out.println("i : " + i + " j : " + j + " area : " +  width * heightInt);
        return width * heightInt;
    }
}
