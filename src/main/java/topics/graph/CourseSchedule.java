package topics.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.


Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */

//leetCode #207
public class CourseSchedule {

    /*
    Initial approach - use a map with sets, this did not account for cycles in the graph
     */

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> courseMap = new HashMap();
        if (!canFinishDfs(prerequisites, courseMap, 0)) {
            return false;
        }

        for (HashSet s : courseMap.values()){
            if (s.size() > numCourses) {
                return false;
            }
        }

        return true;
    }

    public static boolean canFinishDfs(int[][] prerequisites, HashMap<Integer, HashSet<Integer>> courseMap, int nextPair) {


        for (int i = nextPair; i < prerequisites.length; i++) {
            int[] coursePair = prerequisites[i];

            //if courseNum is impossible to take, return false
            if (courseMap.containsKey(coursePair[1])) {
                if (courseMap.get(coursePair[1]).contains(coursePair[0])) {
                    return false;
                }
            }

            if (courseMap.containsKey(coursePair[0])) {
                courseMap.get(coursePair[0]).add(coursePair[1]);
            } else {
                HashSet<Integer> newSet = new HashSet();
                newSet.add(coursePair[1]);
                courseMap.put(coursePair[0], newSet);
            }

            //call can finish
            canFinishDfs(prerequisites, courseMap, nextPair + 1);
        }

        return true;
    }

    /*
    Better approach - uses Topological Sorting of graph to mark nodes visited using indegree array
     */

    private static boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;

        // Convert graph presentation from edges to indegree of adjacent list.
        int[] indegree = new int[numCourses];

        // Indegree - how many prerequisites are needed.
        for (int[] value : prerequisites)
            indegree[value[0]]++;

        // Create a queue of the courses that don't need prerequisites (have indegree of 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.add(i);


        int canFinishCount = queue.size();
        while (!queue.isEmpty()) {
            int course = queue.remove(); // Already finished this prerequisite course.
            for (int[] preReq : prerequisites) {
                if (preReq[1] == course) {
                    indegree[preReq[0]]--;
                    if (indegree[preReq[0]] == 0) {
                        canFinishCount = canFinishCount + 1;
                        queue.add(preReq[0]);
                    }
                }
            }
        }

        return (canFinishCount == numCourses);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 4};
        int[] arr2 = new int[]{4, 3};
        int[] arr3 = new int[]{3, 2};
        int[] arr4 = new int[]{2, 1};
        int[] arr5 = new int[]{1, 0};
        int[][] input = new int[][]{arr1, arr2, arr3, arr4, arr5};

        canFinish2(6, input);

    }

}
