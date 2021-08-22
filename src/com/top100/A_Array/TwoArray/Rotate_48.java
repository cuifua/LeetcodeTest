package com.top100.A_Array.TwoArray;

public class Rotate_48
{
    public void rotate(int[][] matrix)
    {
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++)         //如果有三行矩阵，只斜对角交换两次，所以是n-1
        {
            for (int j = i + 1; j < n; j++)     //斜对角交换，相当于[0][1]---[1][0], [2][0]---[0][2] ....
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 再对每一行以中点进行翻转
        int mid = n >> 1;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < mid; j++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];//假如有n=7行，索引是[0][1][2][3][4][5][6] 那么就是[0][6],[1][5],[2][4]交换
                matrix[i][n - 1 - j] = tmp;         //例如 当j = 2时，和 n-1（=6即这行的最后一个索引）-j 交换
            }
        }
    }
}
