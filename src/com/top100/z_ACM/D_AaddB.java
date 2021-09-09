package com.top100.z_ACM;

import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/4 12:21
 * @Version 1.0
 */
/*
输入描述:
    输入数据包括多组。
    每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
    接下来n个正整数,即需要求和的每个正整数。
输出描述:
    每组数据输出求和的结果

输入
    4 1 2 3 4
    5 1 2 3 4 5
    0
输出
    10
    15
 */
public class D_AaddB
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            int n = sc.nextInt();
            if(n == 0)   break;

            int sum = 0;
            for(int i = 0; i < n; i++)
                sum += sc.nextInt();

            System.out.println(sum);
        }
    }
}
