package com.Company.MeituanII;

/**
 * @Author cuifua
 * @Date 2021/8/23 13:22
 * @Version 1.0
 */
/*
牛牛定义排序子序列为一个数组中一段连续的子序列,并且这段子序列是非递增或者非递减排序的。
牛牛有一个长度为n的整数数组A,他现在有一个任务是把数组A分为若干段排序子序列,牛牛想知道他最少可以把这个数组分为几段排序子序列.
如样例所示,牛牛可以把数组A划分为[1,2,3]和[2,2,1]两个排序子序列,至少需要划分为2个排序子序列,所以输出2

输入描述:
输入的第一行为一个正整数n(1 ≤ n ≤ 10^5)
第二行包括n个整数A_i(1 ≤ A_i ≤ 10^9),表示数组A的每个数字。

输出描述:
输出一个整数表示牛牛可以将A最少划分为多少段排序子序列

输入例子1:
6
1 2 3 2 2 1

输出例子1:
2
 */

/*
下标从1到n-2，统计非相邻极值（a[i] > a[i-1]  &&  a[i] > a[i+1] || a[i] <a [i-1]  &&  a[i]<a[i+1]）的个数cnt
        值得注意的是当上述循环最后一个极值下标为n-3时，需要判断下标为n-2的数是否为极值，如果是cnt+=1
        最后输出cnt+1

 */

import java.util.*;
public class Main_2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int[] a = new int[n];

        for(int i=0 ;i < n ; i++)
            a[i] = scanner.nextInt();

        int cnt = 1;
        for(int i = 1 ; i < n-1 ; i++)
        {
            if(a[i] > a[i-1] && a[i] > a[i+1]  ||  a[i] <a [i-1] && a[i] < a[i+1])
            {
                cnt++;
                if(n-3 != i) i++;
            }
        }
        System.out.println(cnt);
    }
}


