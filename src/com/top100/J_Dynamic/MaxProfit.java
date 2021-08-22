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


//�Ż���ʱ�临�Ӷȴ�O(N?)��O��N��
/*
public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        // �����ж�
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] �±�Ϊ i ���������ʱ�򣬲��ֹɣ�����ӵ�е��ֽ���
        // dp[i][1] �±�Ϊ i ���������ʱ�򣬳ֹɣ�����ӵ�е��ֽ���

        // ��ʼ�������ֹ���ȻΪ 0���ֹɾ���Ҫ��ȥ�� 1 �죨�±�Ϊ 0���Ĺɼ�
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // �ӵ� 2 �쿪ʼ����
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}

 */
