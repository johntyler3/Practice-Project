package topics.graph;

/*
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

Example 1:
Input: N = 2, trust = [[1,2]]
Output: 2

Example 2:
Input: N = 3, trust = [[1,3],[2,3]]
Output: 3

Example 3:
Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1

Example 4:
Input: N = 3, trust = [[1,2],[2,3]]
Output: -1

Example 5:
Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 */

import java.util.HashMap;
import java.util.HashSet;

//leetCode #997
public class FindTheTownJudge {

    /*
    Initial approach - create a hash map of trust and figure out the judge from there
     */

    public int findTheJudge(int N, int[][] trust) {
        if (N ==  0) {
            return -1;
        }

        HashMap<Integer, HashSet<Integer>> trustMap = new HashMap();

        for  (int i = 0; i < trust.length; i++) {
            for (int j = 0; j < trust[0].length; j++) {
                if (j == 0) {
                    if(trustMap.containsKey(trust[i][j])) {
                        trustMap.get(trust[i][j]).add(trust[i][j + 1]);
                    } else {
                        HashSet<Integer> set = new HashSet();
                        set.add(trust[i][j + 1]);
                        trustMap.put(trust[i][j], set);
                    }
                } if (j == 1 && !trustMap.containsKey(trust[i][j])) {
                    trustMap.put(trust[i][j], new HashSet());
                }


            }
        }

        if (trustMap.size() == N || trustMap.size() != (N - 1)) {
            return -1;
        }

        for (HashSet<Integer> s : trustMap.values())  {
            if (s.isEmpty()) { //and everyone else has them
                //TODO : figure out how everyone else trusts this guy
            }
        }
        return -1;
    }

    /*
    Better Solution :

    Intuition:
    Consider trust as a graph, all pairs are directed edge.
    The point with in-degree - out-degree = N - 1 become the judge.

    Explanation:
    Count the degree, and check at the end.

    Time Complexity:
    Time O(T + N), space O(N)

     */

    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1];

        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (count[i] == N - 1) {
                return i;
            }
        }

        return -1;
    }
}
