package com.Zuo.Dynamic;

import org.junit.Test;

/*
【题目】范围上尝试的模型③
    给定一个整数数组arr,代表数值不同的纸牌排成一条线
    玩家A和玩家B依次拿走每张纸牌
    1、规定玩家A先拿，玩家B后拿
    2、但是每个玩家每只能拿走最左或最右的纸牌
    玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数
【思路】
    70 100 1 4
    首先A先拿，A如果先拿70，就会将100暴露给B了，所以A拿4

    70 100 1
    接着B拿，B也不想把100暴露给A，但是100左右都会暴露，只能选择一个比较大的70

    100 1
    继续A拿，心机婊A拿走了100

    B只能拿1 ，最后A104，B71，A赢
 */
public class CardWin
{
    //1、暴力递归法
    public int win(int[] arr)
    {
        if(arr == null || arr.length == 0)
            return 0;

        //返回先手、后手在0---arr.length-1范围上的返回的最大值
        return Math.max(first(arr,0,arr.length-1),
                        second(arr,0,arr.length-1)
                       );
    }

    public int first(int[] arr, int L, int R)
    {
        if(R == L)
            return arr[L];//当剩一张牌的时候，由于是先手，所以这张牌归先手

        //先手如果拿了左边的，后手只能在[L/L+1....R]里拿
        //先手如果拿了右边的，后手只能在[L...R-1/R]里拿
        return Math.max(arr[L]+ second(arr,L+1,R),
                        arr[R]+second(arr,L,R-1)
                       );
    }

    public int second(int[] arr, int L, int R)
    {
        if(L == R)
            return 0; //因为是后手，剩一张牌被先手拿走

        return Math.min(first(arr,L+1,R),
                        first(arr,L,R-1)
                       );
    }





    //3、动态规划法
    public int winDynamic(int[] arr)
    {
        if(arr == null || arr.length == 0)
            return 0;

        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];

        for (int i = 0; i < N; i++)
            f[i][i] = arr[i];

        for (int i = 1; i < N; i++)
        {
            int L = 0;
            int R = i;

            while(L < N && R < N)
            {
                f[L][R] = Math.max(
                        arr[L]+ s[L+1][R],
                        arr[R]+s[L][R-1]
                );

                s[L][R] = Math.min(
                        f[L+1][R],
                        f[L][R-1]
                );

                L++;
                R++;
            }
        }

        return Math.max(f[0][N-1],s[0][N-1]);
    }






    @Test
    public void test()
    {
        int[] arr = {4,7,9,5,19,29,80,4};
        System.out.println(win(arr));
        System.out.println(winDynamic(arr));
    }
}
