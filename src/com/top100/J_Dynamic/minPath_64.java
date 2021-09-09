package com.top100.J_Dynamic;

/**
 * @Author cuifua
 * @Date 2021/9/3 20:49
 * @Version 1.0
 */
/*
����Ŀ��
    ����һ�������Ǹ������� m x n ���� grid �����ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
    ˵����ÿ��ֻ�����»��������ƶ�һ����

�����⡿
    ���룺grid = [[1,3,1],[1,5,1],[4,2,1]]
    �����7
    ���ͣ���Ϊ·�� 1��3��1��1��1 ���ܺ���С��

    ���룺grid = [[1,2,3],[4,5,6]]
    �����12
*/
public class minPath_64
{
    public int minpath(int[][] grid)
    {
        if(grid.length == 0 || grid[0].length == 0 || grid == null || grid[0] == null)   return 0;

        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < row; i++)  dp[i][0] = dp[i-1][0] + grid[i][0];
        for (int i = 1; i < col; i++)  dp[0][i] = dp[0][i-1] + grid[0][i];

        for (int i = 1; i < row; i++)
        {
            for (int j = 1; j < col; j++)
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
        }
        return dp[row-1][col-1];
    }
}
