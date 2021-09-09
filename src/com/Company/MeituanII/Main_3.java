package com.Company.MeituanII;

/**
 * @Author cuifua
 * @Date 2021/8/23 13:23
 * @Version 1.0
 */
/*
牛牛现在有一个n个数组成的数列,牛牛现在想取一个连续的子序列,并且这个子序列还必须得满足:
    最多只改变一个数,就可以使得这个连续的子序列是一个严格上升的子序列,牛牛想知道这个连续子序列最长的长度是多少。

输入描述:
输入包括两行,第一行包括一个整数n(1 ≤ n ≤ 10^5),即数列的长度;
第二行n个整数a_i, 表示数列中的每个数(1 ≤ a_i ≤ 10^9),以空格分割。

输出描述:
输出一个整数,表示最长的长度。

输入例子1:
6
7 2 3 1 5 6

输出例子1:
5
 */
import java.util.*;

public class Main_3
{
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            int N = sc.nextInt();
            int[] a = new int[N];
            int[] maxLen = new int[N];

            for(int i=0 ; i<N ; i++)
                a[i] = sc.nextInt();

            //对a[0]特殊处理
            if (a[1] >= 2)
            {
                maxLen[0] = 2;
                for (int i = 2; i < N; i++)
                {
                    if (a[i] > a[i - 1])
                        maxLen[0]++;
                    else
                        break;
                }
            }
            //对a[N-1]特殊处理
            maxLen[N - 1] = 2;
            for (int i = N - 2; i >= 0; i--)
            {
                if (a[i] > a[i - 1])
                    maxLen[N - 1]++;
                else
                    break;
            }

            //对标号是1~N-2的进行处理
            for (int i = 1; i <= N - 2; i++)
            {
                if (a[i + 1] - a[i - 1] >= 2)
                {
                    maxLen[i] = 3;
                    for (int j = i - 1; j > 0; j--)
                    {
                        if (a[j] > a[j - 1])
                            maxLen[i]++;
                        else
                            break;
                    }
                    for (int j = i + 1; j < N-1; j++)
                    {
                        if (a[j + 1] > a[j])
                            maxLen[i]++;
                        else
                            break;
                    }
                }
                else
                    maxLen[i] = 2;
            }
            Arrays.sort(maxLen);
            System.out.println(maxLen[N-1]);
        }
    }

}