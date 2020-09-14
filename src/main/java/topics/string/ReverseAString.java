package topics.string;

/*
Write a method that takes in a String and returns the reversed version of the String.
 */

//fireCode
public class ReverseAString {

    public static String reverseString(String str){
        String inputString = str;
        String outputString = null;

        if (str != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = (str.length() - 1); i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            outputString = sb.toString();
        }


        return outputString;
    }

}
