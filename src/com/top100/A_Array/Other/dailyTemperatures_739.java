package com.top100.A_Array.Other;

/*
����Ŀ��
    �����ÿ�� ���� �б� temperatures���������ÿһ����Ҫ�ȼ���Ż��и��ߵ��¶ȡ������������֮�󶼲������ߣ����ڸ�λ����0 �����档

��ʾ����
    ����: temperatures = [73,74,75,71,69,72,76,73]
    ���:[1,1,4,2,1,1,0,0]

��ʾ����
    ����: temperatures = [30,40,50,60]
    ���:[1,1,1,0]
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
