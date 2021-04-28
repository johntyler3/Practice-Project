package topics.math;

/*
Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...


Example 1:

Input: columnTitle = "A"
Output: 1

Example 2:
Input: columnTitle = "AB"
Output: 28
 */

//leetCode #171
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int colNum = 0;

        for (int i = 0; i < s.length(); i++) {
            colNum *= 26;
            colNum += (s.charAt(i) + 1) - 'A';
        }

        return colNum;
    }
}
