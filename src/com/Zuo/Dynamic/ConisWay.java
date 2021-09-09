package com.Zuo.Dynamic;

import org.junit.Test;

import java.util.HashMap;

/*
【题目】
    给一个数组，数组存放不同面值钱，和一个目标值，求出有多少种组成的方式
 */
public class ConisWay
{
    //1、暴力递归法
    public int ways(int[] arr, int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return 0;
        return dfs(arr,0,aim);
    }
    public int dfs(int[] arr, int index, int rest) //可以自由使用arr[index...]所有的面值，每一种面值都可以使用任意张
    {
        if(rest < 0)
            return 0;

        if(index == arr.length)//没有货币可以选择了
            return rest == 0 ? 1 : 0;//如果剩余的钱等于0，找到一个方法，返回1

        //当前有货币，arr[index]
        int ways = 0;
        for(int zhang = 0 ; zhang * arr[index] <= rest; zhang++)// 条件是张数乘以选择的面值，不超过目标面值rest
            ways += dfs(arr,index+1,rest - (zhang*arr[index]));

        return ways;
    }


    //2、优化记忆法
    public int waysCache(int[] arr, int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return 0;

        int[][] dp = new int[arr.length+1][aim+1];
        for (int i = 0; i < dp.length; i++)
        {
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        }
        return dfsCache(arr,0,aim,dp);
    }
    public int dfsCache(int[] arr, int index, int rest,int[][] dp)
    {
        if(dp[index][rest] != -1)
            return dp[index][rest];

        if(index == arr.length)//没有货币可以选择了
        {
            dp[index][rest] =  rest == 0 ? 1 : 0;//如果剩余的钱等于0，找到一个方法，返回1
            return dp[index][rest];
        }

        //当前有货币，arr[index]
        int ways = 0;
        for(int zhang = 0 ; zhang * arr[index] <= rest; zhang++)
            ways += dfs(arr,index+1,rest - (zhang*arr[index]));

        dp[index][rest] = ways;
        return ways;
    }


    //3、动态规划法
    public int waysDynamic(int[] arr, int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return 0;

        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];
        dp[N][0] = 1;//暴力递归里当index == arr.length 就return rest == 0 ? 1 : 0 即就是当rest = 0.数组为1

        for(int index = N-1; index >= 0; index--)
        {
            for(int rest = 0; rest <= aim; rest++)
            {
                int ways = 0;
                for(int zhang = 0 ; zhang * arr[index] <= rest; zhang++)
                    ways += dp[index+1][rest - (zhang*arr[index])];

                dp[index][rest] = ways;
            }
        }

        return dp[0][aim];//这个返回是根据暴力递归的返回值决定的，就是原主函数里的return dfs(arr,0,aim)的0.aim
    }


    //4、省略枚举行为
    public int waysDynamicPlus(int[] arr, int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return 0;

        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];
        dp[N][0] = 1;//暴力递归里当index == arr.length 就return rest == 0 ? 1 : 0 即就是当rest = 0.数组为1

        for(int index = N-1; index >= 0; index--)
        {
            for(int rest = 0; rest <= aim; rest++)
            {
               dp[index][rest] = dp[index+1][rest];
               if(rest - arr[index] >= 0)
                   dp[index][rest] += dp[index][rest-arr[index]];
            }
        }

        return dp[0][aim];//这个返回是根据暴力递归的返回值决定的，就是原主函数里的return dfs(arr,0,aim)的0.aim
    }




    @Test
    public void test()
    {
        int[] arr = {5,10,50,100};
        int aim = 1000;
        System.out.println(ways(arr,aim));
        System.out.println(waysCache(arr,aim));
        System.out.println(waysDynamic(arr,aim));
        System.out.println(waysDynamicPlus(arr,aim));
    }
}
