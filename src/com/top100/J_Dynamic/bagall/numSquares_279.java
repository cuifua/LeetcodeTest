package com.top100.J_Dynamic.bagall;

/*
【题目】
    给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
    给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
    完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

【示例】
    输入：n = 12
    输出：3
    解释：12 = 4 + 4 + 4

【示例】
    输入：n = 13
    输出：2
    解释：13 = 4 + 9
 */
public class numSquares_279
{
    public int numSquares(int n)
    {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];

        //初始化
        for (int j = 0; j <= n; j++)
            dp[j] = max;

        dp[0] = 0;//当和为0时，组合的个数为0

        for (int i = 1; i * i <= n; i++)// 遍历物品
        {
            for (int j = i * i; j <= n; j++) // 遍历背包
                if (dp[j - i * i] != max)
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
        }
        return dp[n];
    }
}
