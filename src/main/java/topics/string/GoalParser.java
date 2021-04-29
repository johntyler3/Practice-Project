package topics.string;

/*
You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()"
and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o",
and "(al)" as the string "al". The interpreted strings are then concatenated in the original order.

Given the string command, return the Goal Parser's interpretation of command.

Example 1:
Input: command = "G()(al)"
Output: "Goal"
Explanation: The Goal Parser interprets the command as follows:
G -> G
() -> o
(al) -> al
The final concatenated result is "Goal".

Example 2:
Input: command = "G()()()()(al)"
Output: "Gooooal"

Example 3:
Input: command = "(al)G(al)()()G"
Output: "alGalooG"
 */

//leetCode #1678
public class GoalParser {

    public String interpret(String command) {
        if (command == null || command.length() == 0) {
            return new String();
        }

        StringBuilder sb = new StringBuilder();

        for (int strIndex = 0; strIndex < command.length(); strIndex++) {
            if (command.charAt(strIndex) == 'G') {
                sb.append('G');
            } else if (command.charAt(strIndex) == '(') {
                strIndex++;
                if (command.charAt(strIndex) == ')') {
                    sb.append('o');
                } else {
                    sb.append("al");
                }
            }
        }

        return sb.toString();
    }

}
