package com.top100.J_Dynamic.bagall;

import java.util.Arrays;

/*
【题目】
    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
    你可以认为每种硬币的数量是无限的。

【思路】
    dp[j]代表含义：填满容量为j的背包最少需要多少硬币
    初始化dp数组：因为硬币的数量一定不会超过amount，而amount <= 10^4因此初始化数组值为10001；dp[0] = 0
    转移方程：dp[j] = min(dp[j], dp[j - coin] + 1)
            当前填满容量j最少需要的硬币 = min( 之前填满容量j最少需要的硬币, 填满容量 j - coin 需要的硬币 + 1个当前硬币）
    返回dp[amount]，如果dp[amount]的值为10001没有变过，说明找不到硬币组合，返回-1


【示例】
    输入：coins = [1, 2, 5], amount = 11
    输出：3
    解释：11 = 5 + 5 + 1

【示例】
    输入：coins = [2], amount = 3
    输出：-1

【示例】
    输入：coins = [1], amount = 0
    输出：0

【示例】
    输入：coins = [1], amount = 1
    输出：1

【示例】
    输入：coins = [1], amount = 2
    输出：2
 */
public class money_322
{
    public int coinchange(int[] coins,int amount)
    {
        int[] dp = new int[amount+1];//假如 1 2 5 组成11，最多的就是11个一块钱，所以这里假设dp数组为一个最大值
        Arrays.fill(dp,amount+1);;

        for(int coin : coins)//外层遍历硬币
        {
            for(int j = coin; j < amount + 1; j++)//内层遍历目标值
                dp[j] = Math.min(dp[j],dp[j-coin]+1);//当前填满容量j最少需要的硬币 = min( 之前填满容量j最少需要的硬币, 填满容量 j - coin 需要的硬币 + 1个当前硬币）
        }

    return dp[amount] != 10001 ? dp[amount] : -1;
    }
}
