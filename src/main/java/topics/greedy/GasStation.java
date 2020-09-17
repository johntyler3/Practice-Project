package topics.greedy;

//leetCode #134
public class GasStation {

    public static void main(String[] args) {

        int[] gas2 = {1,2,3,4,5,5,70};
        int[] cost2 = {2,3,4,3,9,6,2};

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        System.out.println(canCompleteCircuitImproved(gas2, cost2));
    }

    //Improved Greedy solution O(N) time complexity O(1) space complexity
    //In this solution we add up all values and determine if a circuit was possible at the end
    public static int canCompleteCircuitImproved(int[] gas, int[] cost) {
        int total = 0, tank = 0, index = 0;
        for (int i = 0; i < cost.length; i++) {
            int cur = gas[i] - cost[i];

            tank += cur;
            //if sum < 0, index can only start from i + 1
            if (tank < 0) {
                index = i + 1;
                tank = 0;
            }
            total += cur;
        }
        return total < 0 ? -1 : index;
    }


    //Original solution O(N^2) Time Complexity O(1) Space Complexity
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            if (canComplete(gas, cost, i)) {
                return i;
            }
        }

        return -1;
    }

    public static boolean canComplete(int[] gas, int[] cost, int trav) {
        int startIndex = trav;
        int tank = gas[trav];
        boolean start = true;

        while (startIndex != trav || start) {

            tank -= cost[trav];
            if (tank < 0) {
                return false;
            }

            trav = (trav + 1 >= gas.length) ? 0 : trav + 1;
            tank += gas[trav];


            start = false;
        }

        return true;
    }

}
