package topics.string;

/*
You are given coordinates, a string that represents the coordinates of a square of the chessboard.
Below is a chessboard for your reference.
Return true if the square is white, and false if the square is black.
The coordinate will always represent a valid chessboard square.
The coordinate will always have the letter first, and the number second.



Example 1:
Input: coordinates = "a1"
Output: false
Explanation: From the chessboard above, the square with coordinates "a1" is black, so return false.

Example 2:
Input: coordinates = "h3"
Output: true
Explanation: From the chessboard above, the square with coordinates "h3" is white, so return true.
 */

//leetCode #1812
public class DetermineColorOfChessboardSquare {

    /*
    Original Approach
     */
    public boolean squareIsWhite(String coordinates) {

        char letter = coordinates.charAt(0);
        char num = coordinates.charAt(1);

        int number = Character.getNumericValue(num) - 1;

        int letterInt = letter - 'a';

        System.out.println(number + " " + letterInt);

        return ((number + letterInt) % 2) != 0;

    }

    /*
    Modified Approach faster
     */
    public boolean squareIsWhite2(String coordinates) {
        return (int)coordinates.charAt(0) % 2 != (int)coordinates.charAt(1) % 2;
    }
}
