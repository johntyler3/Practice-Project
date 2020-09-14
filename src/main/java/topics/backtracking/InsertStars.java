package topics.backtracking;

/*
Given a string, recursively compute a new string where the identical adjacent characters
in the original string are separated by a "*".
 */

//fireCode
public class InsertStars {

    public static String insertPairStar(String s) {

        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        } else if (s.charAt(0) == s.charAt(1)) {
            return s.charAt(0) + "*" + insertPairStar(s.substring(1));
        } else {
            return s.charAt(0) + insertPairStar(s.substring(1));
        }
    }

}
