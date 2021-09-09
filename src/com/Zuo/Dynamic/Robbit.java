package com.Zuo.Dynamic;

/*
【题目】
    假设有排成一行的N个位置，记为1~N，N 一定大于或等于 2
    开始时机器人在其中的M位置上(M 一定是 1~N 中的一个)。
    如果机器人来到1位置，那么下一步只能往右来到2位置；
    如果机器人来到N位置，那么下一步只能往左来到 N-1 位置；
    如果机器人来到中间位置，那么下一步可以往左走或者往右走；
    规定机器人必须走 K 步，最终能来到P位置(P也是1~N中的一个)的方法有多少种？给定四个参数 N、M、K、P，返回方法数
【思路】
    1   2    3   4   5   6   7    --->n个位置
    M->        <-M->       <-M
 */
public class Robbit
{
    //1、暴力递归法
    public int ways1(int N, int M, int K, int P)
    {
        if(N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N)   return 0;

        return walk1(N,M,K,P);
    }

    /**
     * @param N     位置为1~n固定参数
     * @param cur   当前在cur位置，可变参数
     * @param rest  还剩res步没有走，可变参数
     * @param P     P最终目标位置，固定参数
     * @return      只能在1~n位置上移动，当前在cur位置，走完rest步后，停在P位置的方法
     */
    public int walk1(int N, int cur, int rest, int P)//walk(6,3,3,4)一共有6个位置，现在在3位置上，还有3步可以走，最终走到4位置，自始至终6，4是不变的
    {                                               //下一步往左走，就是walk(6,2,2,4),往右走的话就是walk(6,4,2,4),开始递归
        /*
        如果没有剩余步数了，当前的cur位置就是最后的位置
        如果最后的位置停在P上，那么之前做的移动就是有效的
        如果最后的位置没有停在P上，那么之前做的移动就是无效的
       */
        if(rest == 0)
            return cur == P ? 1 : 0;

        //如果还有rest步要走，而当前的cur位置在1上，那么当前这步只能往2走
        //后续过程就是，来到2位置上，还剩rest-1步要走
        if(cur == 1)
            return walk1(N,2,rest-1,P);

        //如果还有rest步要走，而当前的cur位置在最后一个位置上，那么当前这步只能往N-1走
        //后续过程就是，来到N-1位置上，还剩rest-1步要走
        if(cur == N)
            return walk1(N,N-1,rest-1,P);

        //如果还有rest步要走，而当前的cur位置在N位置上，不在边界，可以往左也可以往右,把所有方法相加
        return walk1(N,cur+1,rest-1,P) + walk1(N,cur-1,rest-1,P);
    }


    //2、记忆优化法
    public int ways1Cache(int N, int M, int K, int P)
    {
        if(N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N)   return 0;

        int[][] dp = new int[N+1][K+1];//第一个参数，所有的位置，第二个参数，rest剩余步数，这个dp表，可以把底下递归的所有返回值装下，dp表里放的是可变参
        for(int row = 0; row <= N ; row++)
        {
            for(int col = 0; col <= K; col++)
            {
                dp[row][col] = -1;//表示目前所有参数组合还没开始算呢
            }
        }
        return walk1Cache(N,M,K,P,dp);
    }
    public int walk1Cache(int N, int cur, int rest, int P,int[][] dp)
    {
        if(dp[cur][rest] != -1)
            return dp[cur][rest];

        if(rest == 0)
        {
            dp[cur][rest] = cur == P ? 1 : 0;//先别急着返回，先写缓存
            return dp[cur][rest];
        }


        if(cur == 1)
        {
            dp[cur][rest] = walk1Cache(N,2,rest-1,P,dp);
            return dp[cur][rest];
        }


        if(cur == N)
        {
            dp[cur][rest] =  walk1Cache(N,N-1,rest-1,P,dp);
            return dp[cur][rest];
        }

        dp[cur][rest] = walk1Cache(N,cur+1,rest-1,P,dp) + walk1Cache(N,cur-1,rest-1,P,dp);
        return dp[cur][rest];
    }




    //3、dp优化法
    public static int waysDynamic(int N, int M, int K, int P)
    {
        // 参数无效直接返回0
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N)
            return 0;

        int[][] dp = new int[K + 1][N + 1];
        dp[0][P] = 1;

        for (int i = 1; i <= K; i++)
        {
            for (int j = 1; j <= N; j++) //j是当前位置  i是剩余步数
            {
                if (j == 1)
                    dp[i][j] = dp[i - 1][2];
                 else if (j == N)
                    dp[i][j] = dp[i - 1][N - 1];
                 else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];

            }
        }
        return dp[K][M];
    }
}
