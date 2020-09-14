package topics.sort;

//fireCode
public class MergeTwoSortedArrays {

    public static int[] merge(int[] arrLeft, int[] arrRight) {
        if (arrLeft == null && arrRight == null) {
            return new int[0];
        } else if (arrLeft == null) {
            return arrRight;
        } else if (arrRight == null) {
            return arrLeft;
        }

        int length = (arrLeft.length + arrRight.length);

        int leftIndex = 0;
        int rightIndex = 0;
        int returnIndex = 0;

        int[] returnArray = new int[length];

        while (leftIndex < arrLeft.length) {
            if ((rightIndex == arrRight.length) || (arrLeft[leftIndex] <= arrRight[rightIndex])) {
                returnArray[returnIndex] = arrLeft[leftIndex];
                leftIndex++;
            } else {
                returnArray[returnIndex] = arrRight[rightIndex];
                rightIndex++;
            }
            returnIndex++;
        }

        while (rightIndex < arrRight.length) {
            returnArray[returnIndex] = arrRight[rightIndex];
            returnIndex++;
            rightIndex++;
        }

        return returnArray;
    }

}
