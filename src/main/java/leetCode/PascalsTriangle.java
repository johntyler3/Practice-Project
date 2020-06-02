package leetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList();

        if (numRows == 0) {
            return pascalTriangle;
        }

        ArrayList<Integer> prevList = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            prevList = generateNewList(prevList);
            pascalTriangle.add(prevList);
        }

        return pascalTriangle;
    }

    public ArrayList<Integer> generateNewList(ArrayList<Integer> prevList) {
        ArrayList<Integer> newList = new ArrayList();
        newList.add(1);

        for (int i = 1; i < prevList.size(); i++) {
            newList.add(prevList.get(i - 1) + prevList.get(i));
        }

        if (prevList.size() >= 1) {
            newList.add(1);
        }
        return newList;
    }
}
