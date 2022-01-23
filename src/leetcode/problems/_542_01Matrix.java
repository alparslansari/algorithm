package leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/** 542. 01 Matrix
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 *
 * Example 1:
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 *
 * Example 2:
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 *
 * Constraints:
 *     m == mat.length
 *     n == mat[i].length
 *     1 <= m, n <= 10^4
 *     1 <= m * n <= 10^4
 *     mat[i][j] is either 0 or 1.
 *     There is at least one 0 in mat.
 */
public class _542_01Matrix {
    public int[][] updateMatrixBFS(int[][] mat) {
        if(mat == null || mat.length == 0)
            return mat;

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 0)
                    q.offer(new int[] {i, j});
                else
                    mat[i][j] = -1;
            }
        }

        int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir: dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];

                if(r >= 0 && c >= 0 && r < mat.length && c < mat[0].length && mat[r][c] == -1) {
                    q.offer(new int[] {r, c});
                    mat[r][c] = mat[curr[0]][curr[1]] + 1;
                }
            }
        }

        return mat;
    }
}
