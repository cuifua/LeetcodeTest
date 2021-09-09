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
    每行不定有n个整数，空格隔开。(1 <= n <= 100)。
输出描述:
    每组数据输出求和的结果
输入
    1 2 3
    4 5
    0 0 0 0 0
输出
    6
    9
    0
 */
public class G_AaddB
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            String [] str = sc.nextLine().split(" ");
            int sum = 0;
            for(String num :str)
                sum += Integer.parseInt(num);

            System.out.println(sum);
        }
    }
}
