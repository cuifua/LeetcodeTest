package com.top100.J_Dynamic;

import java.util.ArrayList;
import java.util.List;

/*

     * 杨辉三角   给你一个数字n写出数组
     *  1
     *  1 1
     *  1 2 1
     *  1 3 3 1
     *  1 4 6 4 1
     *  1 5 10 10 5 1


 */
public class YangHui_118
{
    public List<List<Integer>> yh(int n)
    {
        List<List<Integer>> res = new ArrayList<>();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++)
        {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j++)
            {
                if(j == 0 || j == i)
                    arr[i][j] = 1;
                else
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                list.add(arr[i][j]);
            }

            res.add(list);
        }
        return res;
    }
}
