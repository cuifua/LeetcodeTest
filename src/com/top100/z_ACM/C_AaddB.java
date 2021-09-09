package com.top100.z_ACM;

import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/4 12:20
 * @Version 1.0
 */
/*
输入描述:
    输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据有多组, 如果输入为0 0则结束输入
输出描述:
    输出a+b的结果

输入
    1 5
    10 20
    0 0
输出
    6
    30
 */
public class C_AaddB
{
    public static void main(String[] args)
    {
        Scanner sca = new Scanner(System.in);
        while(sca.hasNext())
        {
            int a = sca.nextInt();
            int b = sca.nextInt();

            if(a==0 && b==0)
                break;
            else
                System.out.println(a+b);
        }
    }
}
