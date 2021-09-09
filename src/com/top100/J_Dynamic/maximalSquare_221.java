package com.top100.J_Dynamic;
/*
����Ŀ��
    ��һ���� '0' �� '1' ��ɵĶ�ά�����ڣ��ҵ�ֻ���� '1' ����������Σ��������������
�����⡿
    ���룺matrix =
     [["1","0","1","0","0"],
      ["1","0","1","1","1"],
      ["1","1","1","1","1"],
      ["1","0","0","1","0"]]
    �����4
 */
public class maximalSquare_221
{
    public int maximalSquare(char[][] matrix)
    {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        int[][] dp = new int[row][col];

        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if (matrix[i][j] == '1')
                {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;

                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
