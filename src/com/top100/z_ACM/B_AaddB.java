package com.top100.z_ACM;

import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/4 12:16
 * @Version 1.0
 */
/*
输入描述:
    输入第一行包括一个数据组数t(1 <= t <= 100)
    接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)
输出描述:
    输出a+b的结果
示例1

输入
    2
    1 5
    10 20

输出
    6
    30
 */
public class B_AaddB
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);
        }
    }
}
