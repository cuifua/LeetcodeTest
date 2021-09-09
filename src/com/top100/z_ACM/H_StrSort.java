package com.top100.z_ACM;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/4 12:22
 * @Version 1.0
 */
/*
输入描述:
    输入有两行，第一行n
    第二行是n个空格隔开的字符串
输出描述:
    输出一行排序后的字符串，空格隔开，无结尾空格

输入
    5
    c d a bb e
输出
    a bb c d e
 */
public class H_StrSort
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        String[] list = sc.nextLine().split(" ");
        Arrays.sort(list);
        for(int i = 0; i < num; i++)
            System.out.print(list[i]+" ");
    }
}
