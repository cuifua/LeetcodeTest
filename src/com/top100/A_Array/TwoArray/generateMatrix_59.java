package com.top100.A_Array.TwoArray;
/*
给你一个正整数n ，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的n x n 正方形矩阵 matrix 。

输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]

 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class generateMatrix_59
{
    public int[][] generate(int n)
    {
      int L = 0,R = n-1;
      int Up = 0, Bottom = n-1;
      int map [][] = new int[n][n];
      int num = 1,target = n * n;


      while(num <= target)
      {
          for(int i = L; i < R; i++)  map[Up][i] = num++;
          Up++;
          for(int i = Up; i < Bottom; i++)  map[i][R] = num++;
          R --;
          for(int i = R; R > L; i--)    map[Bottom][i] = num++;
          Bottom --;
          for(int i = Bottom; i > Up; i--)   map[i][L] = num++;
          L++;
      }
      return map;
    }
}

