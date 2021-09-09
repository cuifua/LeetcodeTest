package com.Company.Meituan;

/**
 * @Author cuifua
 * @Date 2021/9/2 16:44
 * @Version 1.0
 */
/*
某比赛已经进入了淘汰赛阶段,已知共有n名选手参与了此阶段比赛，
他们的得分分别是a_1,a_2….a_n,小美作为比赛的裁判希望设定一个分数线m，使得所有分数大于m的选手晋级，其他人淘汰。
但是为了保护粉丝脆弱的心脏，小美希望晋级和淘汰的人数均在[x,y]之间。
显然这个m有可能是不存在的，也有可能存在多个m，如果不存在，请你输出-1，如果存在多个，请你输出符合条件的最低的分数线。


输入描述:
输入第一行仅包含三个正整数n,x,y，分别表示参赛的人数和晋级淘汰人数区间。(1<=n<=50000,1<=x,y<=n)
输入第二行包含n个整数，中间用空格隔开，表示从1号选手到n号选手的成绩。(1<=|a_i|<=1000)

输出描述:
输出仅包含一个整数，如果不存在这样的m，则输出-1，否则输出符合条件的最小的值。


输入例子1:
6 2 3
1 2 3 4 5 6

输出例子1:
3
 */
import java.util.Arrays;
import java.util.Scanner;

/**
 * 美团校招 第10场 第1题
 */
public class Main_1
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n; i++)
            score[i] = in.nextInt();

        /**
         * 符合条件的最低分数线 -> 过线的人多 -> 使用人数限制最大值 y作为过线人数 -> 判断剩下的人数 是否在[x,y]区间 ->
         *      如果在 直接返回
         *      如果不在
         *          如果人数少于x 则直接找到分数最低的第x个人即可
         *          如果人数大于y 则证明找不到一个分数线满足条件
         */

        Arrays.sort(score);// 对成绩排序

        int notOk = n - y;// 没过线的人数
        if (notOk > y)
            System.out.println(-1);
        else if (notOk >= x && notOk <= y)
            System.out.println(score[n-y-1]);
        else
            System.out.println(score[x-1]);
    }
}
