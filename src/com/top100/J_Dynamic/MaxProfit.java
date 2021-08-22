package com.top100.J_Dynamic;

import org.junit.Test;

public class MaxProfit
{
    public int maxprofit (int[] prices)
    {
        int maxprofit = 0;
        //int res = 0;
        for(int i = 0; i < prices.length;i++)
        {
            for(int j = i+1; j<prices.length; j++)
            {
                int x = prices[j] - prices[i];
                if(x > maxprofit)
                {
                    maxprofit = x;
                }
                //res = Math.max(res,profit[j] - profit[i]);
            }
        }
        return maxprofit;
        //return res;

    }



    @Test
    public void test()
    {
        int[] testt= new int[]{2, 3, 7, 5, 1};
        System.out.println(maxprofit(testt));
    }
}


//优化了时间复杂度从O(N?)到O（N）
/*
public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}

 */
