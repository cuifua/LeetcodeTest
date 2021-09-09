package com.top100.J_Dynamic;

import org.junit.Test;

/*
【题目】
    有一个数组，里面是每个员工喝完咖啡所用时间
    a 咖啡机洗杯子时间
    b 咖啡杯子不放入咖啡机洗，自净的时间
    求最短时间所有杯子干净
 */
public class DrinkCoffee
{
    public int Mintime(int[] arr,int a, int b)
    {
        return dfs(arr,a,b,0,0);
    }

    /**
     *
     * @param drinks  【固定变量】  每一个员工喝完咖啡的时间
     * @param a       【固定变量】  咖啡机洗一个杯子的时间
     * @param b       【固定变量】  杯子自净的时间
     * @param index   drinks[0...index-1]都已经干净了。不用你操心了
     * @param washLine  咖啡机可以洗杯子的可用时间，何时可用
     * @return
     */
    public int dfs(int[] drinks, int a, int b, int index, int washLine)
    {
        if(index == drinks.length - 1)
            return Math.min( Math.max(washLine,drinks[index]) + a, drinks[index] + b);
                            //机子可用来洗杯子的时间和员工才喝完的时间的最大值，机子空闲咖啡没喝完，不能用，咖啡喝完机子没空不行

        //用咖啡机
        int wash = Math.max(washLine,drinks[index]) + a;//洗index这一杯，结束的时间点
        int next1 = dfs(drinks,a,b,index+1,wash);//index+1后续洗干净所有杯子的时间
        int p1 = Math.max(wash,next1);//你自己洗完和你后面杯子洗完取最大值，因为你洗完了后面还没洗完

        //用自净
        int dry = drinks[index] + b;
        int next2 = dfs(drinks,a,b,index+1,washLine);
        int p2 = Math.max(dry,next2);

        return Math.max(p1,p2);
    }


    public int dfsDynamic(int[] drinks, int a, int b)
    {
        if(a >= b)
            return drinks[drinks.length-1] + b;


        int N = drinks.length;
        int limit = 0;//咖啡机什么时候可用
        for(int i = 0; i < N; i++)//遍历我所有杯子喝完的时间
            limit = Math.max(limit,drinks[i] + a);

        int[][] dp = new int[N][limit+1];
         for(int washLine = 0; washLine <= limit; washLine++)//N-1行所有值[basecase]
             dp[N-1][washLine] = Math.min(Math.max(washLine,drinks[N-1]) + a, drinks[N-1] + b);

        for (int index = N-2; index >= 0 ; index--)
        {
            for (int washLine = 0; washLine <= limit ; washLine++)
            {
                int p1 = Integer.MAX_VALUE;
                int wash = Math.max(washLine,drinks[index]) + a;//洗index这一杯，结束的时间点
                if(wash <= limit)
                    p1 = Math.max(wash,dp[index+1][wash]);

                int p2 = Math.max(drinks[index] + b,dp[index+1][washLine]);

                dp[index][washLine] =  Math.min(p1,p2);
            }
        }



        return dp[0][0];//暴力递归的表达式写的啥就返回啥
    }






    @Test
    public void test()
    {
        int[] arr = {1,1,5,5,7,10,12,12,12,12,12,12,15};
        int a = 3;
        int b = 10;
        System.out.println(Mintime(arr,a,b));
        System.out.println(dfs(arr,a,b,0,0));
    }
}
