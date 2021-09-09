package com.top100.z_ACM;

import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/4 12:16
 * @Version 1.0
 */
/*
输入描述:
    输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。
输出描述:
    输出a+b的结果

示例1
输入
    1 5
    10 2

复制
    6
    30
 */
public class A_AaddB
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }

}
