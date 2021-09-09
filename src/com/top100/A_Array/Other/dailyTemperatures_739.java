package com.top100.A_Array.Other;

/*
【题目】
    请根据每日 气温 列表 temperatures，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0 来代替。

【示例】
    输入: temperatures = [73,74,75,71,69,72,76,73]
    输出:[1,1,4,2,1,1,0,0]

【示例】
    输入: temperatures = [30,40,50,60]
    输出:[1,1,1,0]
 */
public class dailyTemperatures_739
{
    public int[] dailyTemperatures(int[] temperatures)
    {
        int len = temperatures.length;
        int[] res = new int[len];

        for(int i = 0; i < len; i++)
        {
            for(int j = i+1; j < len; j++)
            {
                if(temperatures[j] > temperatures[i])
                {
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }
}
