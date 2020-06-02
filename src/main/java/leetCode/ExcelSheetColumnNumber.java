package leetCode;

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
