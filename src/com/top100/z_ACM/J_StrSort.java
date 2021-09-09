package com.top100.z_ACM;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/4 12:23
 * @Version 1.0
 */
/*
输入描述:
    多个测试用例，每个测试用例一行。
    每行通过,隔开，有n个字符，n＜100
输出描述:
    对于每组用例输出一行排序后的字符串，用','隔开，无结尾空格
输入
    a,c,bb
    f,dddd
    nowcoder
输出
    a,bb,c
    dddd,f
    nowcoder
 */
public class J_StrSort
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine())
        {
            String[] str = sc.nextLine().split(",");
            Arrays.sort(str);

            for(int i = 0; i < str.length; i++)
            {
                if (i == str.length - 1) System.out.print(str[i]);

                else System.out.print(str[i] + ",");
            }
        }
    }
}
