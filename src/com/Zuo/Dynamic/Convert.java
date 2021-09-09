package com.Zuo.Dynamic;

import org.junit.Test;

/*
【题目】从左往右尝试模型①
    规定1和A对应，2和B对应，3和C对应，那么一个数字字符串比如“111”就可以转化为“AAA”“AK”"KA"
    给定一个只有数字字符组成的字符串，返回多少中转化结果
【思路】
    给你一个“11111”
    第一个1转化为A，剩下四个自己转化去，
    前两个1转化为K，剩下三个自己转化去
    前三个1没有办法转化，因为只有26个字母
 */
public class Convert
{
    //1、暴力递归法
    public int convert(String s)
    {
        if(s == null || s.length() == 0)   return 0;
        return dfs(s.toCharArray(),0);
    }
    public int dfs(char[] str, int i)//str[0...i-1]上已经转化完了固定了
    {
        if(i == str.length)//i来到终止位置
            return 1;

        //i对应A，2对应B....没有0对应的字母，出现0直接返回0
        if(str[i] == '0')
            return 0;

        //i没有到终止位置
        // str[i]不是字符‘0’
        if(str[i] == '1')
        {
            int res = dfs(str,i + 1);//i 自己作为单独的部分，后续有多少种方法

            if(i + 1 < str.length)
                    res += dfs(str,i+2);//(i和i+1)作为单独的部分，后续有多少种方法

            return res;
        }

        if(str[i] == '2')
        {
            int res = dfs(str,i+1);//i 自己作为单独的部分，后续有多少种方法

            if(i + 1 < str.length && (str[i+1] >= '0' && str[i+1] <= '6'))
                res += dfs(str,i+2);

            return res;
        }

        //str[i] = '3'~'9'
        return dfs(str,i+1);
    }



    //3、动态规划法
    public int convertDynamic(String s)
    {
        if(s == null || s.length() == 0)   return 0;

        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N+1];
        dp[N] = 1;

        for (int i = N-1; i >= 0 ; i--)
        {
            if(str[i] == '0')
                dp[i] = 0;

            if(str[i] == '1');
            {
                dp[i] = dp[i+1];
                if(i+1 < str.length)
                    dp[i] += dp[i + 2];
            }

            if(str[i] == '2')
            {
                dp[i] = dp[i+1];
                if(i + 1 < str.length && (str[i+1] >= '0' && str[i+1] <= '6'))
                    dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }
}
