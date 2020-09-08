package topics.math;

//leetCode #69
public class SqrtX {

    /*

    A little trick is using i <= x / i for comparison, instead of i * i <= x, to avoid exceeding integer upper limit.

     */

    //This is a binary search solution which runs in O(log(N)) time
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int start = 1, end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result
                return mid;
            else if (mid > x / mid)// Keep checking the left part
                end = mid;
            else
                start = mid + 1;// Keep checking the right part
        }
        return start;
    }

    //This is the brute force solution which runs in O(Sqrt(N)) time
    public int mySqrt2(int x) {
        if (x == 0) return 0;
        for (int i = 1; i <= x / i; i++)
            if (i <= x / i && (i + 1) > x / (i + 1))// Look for the critical point: i*i <= x && (i+1)(i+1) > x
                return i;
        return -1;
    }

}
