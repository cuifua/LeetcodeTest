package com.Company.MeituanII;

/**
 * @Author cuifua
 * @Date 2021/8/23 13:13
 * @Version 1.0
 */
/*
牛牛有一个数组，里面的数可能不相等，现在他想把数组变为：所有的数都相等。问是否可行。
牛牛可以进行的操作是：将数组中的任意一个数改为这个数的两倍。
这个操作的使用次数不限，也可以不使用，并且可以对同一个位置使用多次。

输入描述:
输入一个正整数N (N <= 50)
接下来一行输入N个正整数，每个数均小于等于1e9.

输出描述:
假如经过若干次操作可以使得N个数都相等，那么输出"YES", 否则输出"NO"

输入例子1:
2
1 2

输出例子1:
YES
 */
/*
此题知识点应该是考如何判断一个整数是2的指数幂

满足YES条件，可知所有数因式分解后，只有2的个数不同.
因此一个for循环，两个两个处理，用大数除以小数，得到商和余数.
如果商不是2的幂，或者余数不等于0，则终止循环，输出NO。

证明商是否2的指数幂，可以使用二进制规律，2的指数幂对应的二进制中1的个数为1.
因此可以通过 n & (n-1) == 0 判断商是否2的指数幂。如8&7==0, 16&15=0
 */

import java.util.*;
public class Main_1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];

        for(int i = 0 ; i < n ; i++)
            a[i] = scanner.nextInt();

        for(int i = 1 ; i < n ; i++)
        {
            int small, big;

            if(a[i] > a[i-1])
            {
                small = a[i-1];
                big = a[i];
            }
            else
            {
                small = a[i];
                big = a[i-1];
            }

            int remainder = big % small;   //余数
            int quotient = big / small;    //商

            if(remainder != 0 || (quotient & (quotient-1)) != 0)
            {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
