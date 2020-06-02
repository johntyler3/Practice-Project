package leetCode;

public class RomanToInteger {
    public int romanToInt(String s) {
        int[] map = new int[256];
        map['I'] = 1; map['V'] = 5; map['X'] = 10; map['L'] = 50; map['C'] = 100; map['D'] = 500; map['M'] = 1000;

        int returnInt = 0;
        int previousInt = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            int currentInt = map[s.charAt(i)];

            if (currentInt < previousInt) {
                returnInt -= currentInt;
            } else {
                previousInt = currentInt;
                returnInt += currentInt;
            }
        }
        return returnInt;
    }
}
