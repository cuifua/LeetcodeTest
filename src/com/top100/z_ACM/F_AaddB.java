package com.top100.z_ACM;

import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/4 12:21
 * @Version 1.0
 */
/*
输入描述:
    输入数据有多组, 每行表示一组输入数据。
    每行的第一个整数为整数的个数n(1 <= n <= 100)。
    接下来n个正整数, 即需要求和的每个正整数。
输出描述:
    每组数据输出求和的结果
输入
    4 1 2 3 4
    5 1 2 3 4 5
输出
    10
    15
 */
public class F_AaddB
{
    public static void main(String[] ars)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            int n = sc.nextInt();
            int sum =0;

            for (int i = 0;i < n; i++)
                sum += sc.nextInt();

            System.out.println(sum);
        }
    }
}
