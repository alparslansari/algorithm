package leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 *
 * Example 1:
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 *
 * Example 2:
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 *
 * Constraints:
 *     m == mat.length
 *     n == mat[i].length
 *     1 <= m, n <= 10^4
 *     1 <= m * n <= 10^4
 *     -10^5 <= mat[i][j] <= 10^5
 */
public class _498DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        // Check for empty matrices
        if(matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // The two arrays as explained in the algorithm
        int[] result = new int[N*M];
        int k = 0;
        ArrayList<Integer> temp = new ArrayList<Integer>();

        for(int d=0;d<N+M-1;d++)
        {
            temp.clear();
            // We need to figure out the "head" of this diagonal
            // The elements in the first row and the last column
            // are the respective heads.
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            // Iterate until one of the indices goes out of scope
            // Take note of the index math to go down the diagonal
            while (r<N && c > -1){
                temp.add(matrix[r][c]);
                r++;
                c--;
            }

            // Reverse even numbered diagonals.
            if(d % 2 == 0){
                Collections.reverse(temp);
            }

            for(int i=0;i<temp.size();i++){
                result[k++] = temp.get(i);
            }
        }
        return result;
    }
}
