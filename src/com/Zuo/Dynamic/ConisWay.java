package com.Zuo.Dynamic;

import org.junit.Test;

import java.util.HashMap;

/*
����Ŀ��
    ��һ�����飬�����Ų�ͬ��ֵǮ����һ��Ŀ��ֵ������ж�������ɵķ�ʽ
 */
public class ConisWay
{
    //1�������ݹ鷨
    public int ways(int[] arr, int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return 0;
        return dfs(arr,0,aim);
    }
    public int dfs(int[] arr, int index, int rest) //��������ʹ��arr[index...]���е���ֵ��ÿһ����ֵ������ʹ��������
    {
        if(rest < 0)
            return 0;

        if(index == arr.length)//û�л��ҿ���ѡ����
            return rest == 0 ? 1 : 0;//���ʣ���Ǯ����0���ҵ�һ������������1

        //��ǰ�л��ң�arr[index]
        int ways = 0;
        for(int zhang = 0 ; zhang * arr[index] <= rest; zhang++)// ��������������ѡ�����ֵ��������Ŀ����ֵrest
            ways += dfs(arr,index+1,rest - (zhang*arr[index]));

        return ways;
    }


    //2���Ż����䷨
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

        if(index == arr.length)//û�л��ҿ���ѡ����
        {
            dp[index][rest] =  rest == 0 ? 1 : 0;//���ʣ���Ǯ����0���ҵ�һ������������1
            return dp[index][rest];
        }

        //��ǰ�л��ң�arr[index]
        int ways = 0;
        for(int zhang = 0 ; zhang * arr[index] <= rest; zhang++)
            ways += dfs(arr,index+1,rest - (zhang*arr[index]));

        dp[index][rest] = ways;
        return ways;
    }


    //3����̬�滮��
    public int waysDynamic(int[] arr, int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return 0;

        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];
        dp[N][0] = 1;//�����ݹ��ﵱindex == arr.length ��return rest == 0 ? 1 : 0 �����ǵ�rest = 0.����Ϊ1

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

        return dp[0][aim];//��������Ǹ��ݱ����ݹ�ķ���ֵ�����ģ�����ԭ���������return dfs(arr,0,aim)��0.aim
    }


    //4��ʡ��ö����Ϊ
    public int waysDynamicPlus(int[] arr, int aim)
    {
        if(arr == null || arr.length == 0 || aim < 0)
            return 0;

        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];
        dp[N][0] = 1;//�����ݹ��ﵱindex == arr.length ��return rest == 0 ? 1 : 0 �����ǵ�rest = 0.����Ϊ1

        for(int index = N-1; index >= 0; index--)
        {
            for(int rest = 0; rest <= aim; rest++)
            {
               dp[index][rest] = dp[index+1][rest];
               if(rest - arr[index] >= 0)
                   dp[index][rest] += dp[index][rest-arr[index]];
            }
        }

        return dp[0][aim];//��������Ǹ��ݱ����ݹ�ķ���ֵ�����ģ�����ԭ���������return dfs(arr,0,aim)��0.aim
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
