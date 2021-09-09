package com.Company.Meituan;

/**
 * @Author cuifua
 * @Date 2021/9/2 16:47
 * @Version 1.0
 */
/*
我们称一个长度为n的序列为正则序列，当且仅当该序列是一个由1~n组成的排列，即该序列由n个正整数组成，取值在[1,n]范围，且不存在重复的数，同时正则序列不要求排序
有一天小团得到了一个长度为n的任意序列，他需要在有限次操作内，将这个序列变成一个正则序列，每次操作他可以任选序列中的一个数字，并将该数字加一或者减一。
请问他最少用多少次操作可以把这个序列变成正则序列？


输入描述:
输入第一行仅包含一个正整数n，表示任意序列的长度。(1<=n<=20000)
输入第二行包含n个整数，表示给出的序列，每个数的绝对值都小于10000。

输出描述:
输出仅包含一个整数，表示最少的操作数量。


输入例子1:
5
-1 2 3 10 100

输出例子1:
103
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main_2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();

        Arrays.sort(arr);//已经排好序了，那么剩下的哪些数字不在坑位就可以直接计算了
        int res=0;

        for(int i=0; i<n; i++)
            res += Math.abs(arr[i]-(i+1));//交换的次数就是自己本身的值和下标的差值

        System.out.println(res);
    }
}