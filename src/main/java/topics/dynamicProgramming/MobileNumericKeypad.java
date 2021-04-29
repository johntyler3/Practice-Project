package topics.dynamicProgramming;

/*
    Given the mobile numeric keypad.
    You can only press buttons that are up, left, right or down to the current button.
    You are not allowed to press bottom row corner buttons (i.e. * and # ).

    {'1','2','3'}
    {'4','5','6'}
    {'7','8','9'}
    {'*','0','#'}

    Given a number N, find out the number of possible numbers of given length.
    Examples:
    For N=1, number of possible numbers would be 10 (0, 1, 2, 3, …., 9)
    For N=2, number of possible numbers would be 36

    If we start with 0, valid numbers will be 00, 08 (count: 2)
    If we start with 1, valid numbers will be 11, 12, 14 (count: 3)
    If we start with 2, valid numbers will be 22, 21, 23,25 (count: 4)
    If we start with 3, valid numbers will be 33, 32, 36 (count: 3)
    If we start with 4, valid numbers will be 44,41,45,47 (count: 4)
    If we start with 5, valid numbers will be 55,54,52,56,58 (count: 5)
 */

//geeksForGeeks Mobile Numeric Keypad Problem
public class MobileNumericKeypad {

    /*
        Recursive Solution :
    */

    // left, up, right, down
    // move from current location
    private static int[] row = {0, 0, -1, 0, 1};
    private static int[] col = {0, -1, 0, 1, 0};

    // Returns count of numbers of length
    // n starting from key position
    // (i, j) in a numeric keyboard.
    static int getCountUtil(char[][] keypad, int i, int j, int n) {
        if (keypad == null || n <= 0)
            return 0;

        // From a given key, only one
        // number is possible of length 1
        if (n == 1)
            return 1;

        int totalCount = 0;

        // move left, up, right, down from current location and if new location is valid, then
        // get number count of length (n-1) from that new position and add in count obtained so far
        for (int move = 0; move < 5; move++) {
            int ro = i + row[move];
            int co = j + col[move];
            if (ro >= 0 && ro <= 3 && co >=0 && co <= 2 &&
                    keypad[ro][co] != '*' && keypad[ro][co] != '#')
            {
                totalCount += getCountUtil(keypad, ro, co, n - 1);
            }
        }
        return totalCount;
    }

    // Return count of all possible numbers of length n in a given numeric keyboard
    static int getCount(char keypad[][], int n)
    {
        // Base cases
        if (keypad == null || n <= 0)
            return 0;
        if (n == 1)
            return 10;

        int totalCount = 0;
        // Loop on keypad row
        for (int i = 0; i < 4; i++) {
            // Loop on keypad column
            for (int j = 0; j < 3; j++) {
                // Process for 0 to 9 digits
                if (keypad[i][j] != '*' && keypad[i][j] != '#') {
                    // Get count when number is starting from key position (i, j) and add in count obtained so far
                    totalCount += getCountUtil(keypad, i, j, n);
                }
            }
        }
        return totalCount;
    }

    // Driver code
    public static void main(String[] args)
    {
        char keypad[][] = {{'1','2','3'},
                {'4','5','6'},
                {'7','8','9'},
                {'*','0','#'}};
//        System.out.printf("Count for numbers of"+ " length %d: %d", 1, getCount(keypad, 1));
//        System.out.printf("\nCount for numbers of" + "length %d: %d", 2, getCount(keypad, 2));
//        System.out.printf("\nCount for numbers of" + "length %d: %d", 3, getCount(keypad, 3));
//        System.out.printf("\nCount for numbers of" + "length %d: %d", 4, getCount(keypad, 4));
//        System.out.printf("\nCount for numbers of" + "length %d: %d", 5, getCount(keypad, 5));


//        System.out.printf("Count for numbers of length %d: %d\n", 1, getDynamicCount(keypad, 1));
//        System.out.printf("Count for numbers of length %d: %d\n", 2, getDynamicCount(keypad, 2));
        System.out.printf("Count for numbers of length %d: %d\n", 3, getDynamicCount(keypad, 3));
//        System.out.printf("Count for numbers of length %d: %d\n", 4, getDynamicCount(keypad, 4));
//        System.out.printf("Count for numbers of length %d: %d\n", 5, getDynamicCount(keypad, 5));
    }


    /*
        Dynamic Programming Solution :
    */


    // Return count of all possible numbers of length n
    // in a given numeric keyboard
    static int getDynamicCount(char keypad[][], int n)
    {
        if(keypad == null || n <= 0)
            return 0;
        if(n == 1)
            return 10;

        // left, up, right, down move from current location
        int row[] = {0, 0, -1, 0, 1};
        int col[] = {0, -1, 0, 1, 0};

        // taking n+1 for simplicity - count[i][j] will store
        // number count starting with digit i and length j
        int [][]count = new int[10][n + 1];
        int i = 0, j = 0, k = 0, move = 0, ro = 0, co = 0, num = 0;
        int nextNum = 0, totalCount = 0;

        // count numbers starting with digit i and of lengths 0 and 1
        for (i = 0; i <= 9; i++)
        {
            count[i][0] = 0;
            count[i][1] = 1;
        }

        // Bottom up - Get number count of length 2, 3, 4, ... , n
        for (k = 2; k <= n; k++)
        {
            for (i = 0; i < 4; i++) // Loop on keypad row
            {
                for (j = 0; j < 3; j++) // Loop on keypad column
                {
                    // Process for 0 to 9 digits
                    if (keypad[i][j] != '*' &&
                            keypad[i][j] != '#')
                    {
                        // Here we are counting the numbers starting with
                        // digit keypad[i][j] and of length k keypad[i][j]
                        // will become 1st digit, and we need to look for
                        // (k-1) more digits
                        num = keypad[i][j] - '0';
                        count[num][k] = 0;

                        // move left, up, right, down from current location
                        // and if new location is valid, then get number
                        // count of length (k-1) from that new digit and
                        // add in count we found so far
                        for (move = 0; move < 5; move++) {
                            ro = i + row[move];
                            co = j + col[move];
                            if (ro >= 0 && ro <= 3 && co >= 0 &&
                                    co <= 2 && keypad[ro][co] != '*' &&
                                    keypad[ro][co] != '#')
                            {
                                nextNum = keypad[ro][co] - '0';
                                count[num][k] += count[nextNum][k - 1];
                            }
                        }
                    }
                }
            }
        }

        // Get count of all possible numbers of length "n"
        // starting with digit 0, 1, 2, ..., 9
        totalCount = 0;
        for (i = 0; i <= 9; i++)
            totalCount += count[i][n];
        return totalCount;
    }
}
