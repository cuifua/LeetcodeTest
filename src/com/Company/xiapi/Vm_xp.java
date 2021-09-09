package com.Company.xiapi;

class Vm_xp
{
    public int bestFit(int V, int[] item)
    {
        // write code here
        boolean[] dp = new boolean[V + 1];
        dp[0] = true;

        for (int i = 0; i < item.length; i++)
        {
            for (int j = V; j >= 0; j--)
            {
                if ((dp[j]) && (j + item[i] <= V))
                    dp[j + item[i]] = true;
            }
        }

        int i;
        for (i = V; i >= 0; i--)
        {
            if (dp[i])
                return V - i;
        }

        return V;
    }
}