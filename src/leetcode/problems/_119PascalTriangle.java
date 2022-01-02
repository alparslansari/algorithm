package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/** 119. Pascal's Triangle II
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 *
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 *
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 * Constraints:
 *     0 <= rowIndex <= 33
 * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
 */
public class _119PascalTriangle {

    // Dynamic Programming - Memory Efficient
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = getInitialVal();
        for (int i = 0; i < rowIndex; i++) {
            for(int j=i;j>0;j--)
            {
                row.set(j, row.get(j) + row.get(j-1));
            }
            row.add(1);
        }
        return row;
    }

    // Dynamic Programming
    public List<Integer> getRowDP(int rowIndex){
        List<Integer> curr, prev = getInitialVal();
        for (int i = 1; i <=rowIndex ; i++) {
            curr = getInitialVal();
            for (int j = 1; j < i; j++)
                curr.add(prev.get(j-1)+prev.get(j));
            curr.add(1);
            prev = curr;
        }
        return prev;
    }

    private List<Integer> getInitialVal()
    {
        return new ArrayList<>(){
            {
                add(1);
            }
        };
    }


    // Brute force approach
    public List<Integer> getRowBruteForce(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++)
        {
            ans.add(getNum(rowIndex, i));
        }
        return ans;
    }

    private int getNum(int row, int col) {
        if(row == 0 || col == 0 || row == col) return 1;
        return getNum(row-1,col-1) + getNum(row-1,col);
    }
}
