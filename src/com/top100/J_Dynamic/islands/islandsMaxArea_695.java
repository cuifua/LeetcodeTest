package com.top100.J_Dynamic.islands;

/*
【题目】
    给定一个包含了一些 0 和 1 的非空二维数组 grid，一个岛屿是一组相邻的 1（代表陆地），
    这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表海洋）包围着
    找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 0
【思路】
    这道题目只需要对每个岛屿做 DFS 遍历，求出每个岛屿的面积就可以了。求岛屿面积的方法也很简单，代码如下，每遍历到一个格子，就把面积加一。
 */
public class islandsMaxArea_695
{
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[0].length; c++)
            {
                if (grid[r][c] == 1)
                {
                    int a = area(grid, r, c);
                    res = Math.max(res, a);
                }
            }
        }
        return res;
    }

    int area(int[][] grid, int row, int col)
    {
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0)
            return -1;

        if (grid[row][col] != 1)
            return 0;

        grid[row][col] = 2;

        return 1
                + area(grid, row - 1, col)
                + area(grid, row + 1, col)
                + area(grid, row, col - 1)
                + area(grid, row, col + 1);
    }
}
