package com.example.leetcode.editor.cn;

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1223 👎 0


import java.util.Deque;
import java.util.LinkedList;

public class NumberOfIslands {

    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();

        char[][] a = new char[][] {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        System.out.println(solution.numIslands(a)); // 1

        char[][] b = new char[][] {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(solution.numIslands(b)); // 3
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * DFS
     * 时间 O(m * n)
     * 空间 O(m * n)
     *
     * BFS
     * 时间 O(m * n)
     * 空间 O(min(m, n))
     */
    public int numIslands(char[][] grid) {
        int islandNum = 0;

        int R = grid.length;
        int C = grid[0].length;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == '1') {
                    ++islandNum;
                    dfs(grid, i, j);
//                    bfs(grid, i, j);
                }
            }
        }

        return islandNum;
    }

    /**
     * 深度优先遍历，将相邻 grid[r][c] 相邻的 1 置为 0
     */
    private void dfs(char[][] grid, int r, int c) {
        int R = grid.length;
        int C = grid[0].length;

        if (r < 0 || r >= R || c < 0 || c >= C || grid[r][c] == '0') {
            return;
        }

        // 将本元素先置为 0
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    private void bfs(char[][] grid, int r, int c) {
        int R = grid.length;
        int C = grid[0].length;

        if (grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        Deque<Integer> neighbors = new LinkedList<>();
        neighbors.add(r * C + c);
        while (!neighbors.isEmpty()) {
            Integer id = neighbors.remove();
            int row = id / C;
            int col = id % C;

            if (row > 0 && grid[row - 1][col] == '1') {
                grid[row - 1][col] = '0';
                neighbors.add((row - 1) * C + col);
            }
            if (row < R - 1 && grid[row + 1][col] == '1') {
                grid[row + 1][col] = '0';
                neighbors.add((row + 1) * C + col);
            }
            if (col > 0 && grid[row][col - 1] == '1') {
                grid[row][col - 1] = '0';
                neighbors.add(row * C + col - 1);
            }
            if (col < C - 1 && grid[row][col + 1] == '1') {
                grid[row][col + 1] = '0';
                neighbors.add(row * C + col + 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}