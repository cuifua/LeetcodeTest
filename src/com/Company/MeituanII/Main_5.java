package com.Company.MeituanII;

/**
 * @Author cuifua
 * @Date 2021/8/23 13:25
 * @Version 1.0
 */
/*
牛牛想对一个数做若干次变换，直到这个数只剩下一位数字。
变换的规则是：将这个数变成 所有位数上的数字的乘积。比如285经过一次变换后转化成2*8*5=80.
问题是，要做多少次变换，使得这个数变成个位数。

输入描述:
输入一个正整数。小于等于2,000,000,000。

输出描述:
输出一个整数，表示变换次数。

输入例子1:
285

输出例子1:
2
 */
import java.util.Scanner;

public class Main_5
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextInt();

        int count = 0;
        long temp = 1;

        while (num / 10 != 0)
        {
            //每次来把数字转成字符串
            //String s=Double.toString(num);
            //循环获取乘积
            count++;
            while (num % 10 != 0 || String.valueOf(num).length()>1)
            {
                long now= num % 10;
                num=num/10;
                temp = temp * now;
            }
            num = temp;
            temp = 1;
        }
        System.out.println(count);
    }
}
