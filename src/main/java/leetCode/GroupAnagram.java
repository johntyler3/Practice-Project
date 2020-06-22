package leetCode;

import java.util.*;

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringMap = new HashMap();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);

            if (!stringMap.containsKey(key)) {
                stringMap.put(key, new ArrayList());
            }
            stringMap.get(key).add(s);
        }


        return new ArrayList(stringMap.values());
    }

}
