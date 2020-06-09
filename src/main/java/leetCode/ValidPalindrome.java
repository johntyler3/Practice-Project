package leetCode;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int backChar = s.length() - 1;
        int frontChar = 0;

        while (frontChar <= backChar) {
            Character front = Character.toLowerCase(s.charAt(frontChar));
            Character back = Character.toLowerCase(s.charAt(backChar));

            if (!(Character.isDigit(front) || Character.isLetter(front))) {
                frontChar++;
            } else if (!(Character.isDigit(back) || Character.isLetter(back))) {
                backChar--;
            } else if (!(front.equals(back))){
                return false;
            } else {
                frontChar++;
                backChar--;
            }
        }


        return true;
    }

}
