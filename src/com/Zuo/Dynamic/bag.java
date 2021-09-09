package com.Zuo.Dynamic;

import org.junit.Test;

/*
【题目】从左往右尝试模型②
    给定两个长度都为N的数组Weights和values
    weights[i] 和 values[i]分别代表i号物品的重量和价值
    给定一个正数bag,表示一个载重bag的袋子
    你装的物品不能超过这个重量
    返回能装下的最多的价值是多少
 */
public class bag
{
    //1、暴力递归法
    public int getMaxValue(int[] w, int[] v, int bag)
    {
        //return dfs1(w,v,0,0,bag);
        return dfs2(w,v,0,bag);
    }

    /*
    不变的：int[] w, int[] v,int bag
    index最大价值,选择要或者不要
    0...index-1 上做了货物的选择，使得你已经达到的重量是多少alreadyW
    如果返回-1，认为没有方案
    如果不返回-1，认为返回的值是真实价值
     */
    public int dfs1(int[] w, int[] v, int index, int alreadyW, int bag)
    {
        if(alreadyW > bag)
            return -1;

        if(index == w.length)
            return 0;

        int p1 = dfs1(w,v,index+1,alreadyW,bag);//这里依旧是alreadyW,表示没有要当前的货
        int p2next = dfs1(w,v,index+1,alreadyW+w[index],bag);//这里alreadyW+w[index],表示要了当前的货

        int p2 = -1;
        if(p2next != -1)
            p2 = v[index]+p2next;

        return Math.max(p1,p2);
    }

    /*
    只剩下rest的空间了
    index...货物自由选择，但剩余空间不要小于0
    返回index...货物能获得的最大价值
    */
    public int dfs2(int[] w, int[] v, int index, int rest)
    {
        if(rest <= 0)
            return -1;

        if(index == w.length)//index如果来到终止位置，返回0的价值
            return 0;

        int p1 = dfs2(w,v,index+1,rest); //不要index位置上的货物
        int p2next = dfs2(w,v,index+1,rest-w[index]);//要index位置上的货物

        int p2 = -1;
        if(p2next != -1)
            p2 = v[index]+p2next;

        return Math.max(p1,p2);
    }



    //3、动态规划法
    public int getMaxValueDynamic(int[] w, int[] v, int bag)
    {
        int N = w.length;
        int[][] dp = new int[N+1][bag+1];

        for (int index = N-1; index >= 0 ; index--)//从下面的行往上
        {
            for (int rest = 0; rest <= bag ; rest++)//rest剩余是从左往右
            {
                int p1 = dp[index+1][rest];
                int p2 = -1;
                if(rest - w[index] >= 0)
                    p2 = v[index] + dp[index+1][rest - w[index]];

                dp[index][rest] = Math.max(p1,p2);
            }
        }
        return dp[0][bag];
    }
}
