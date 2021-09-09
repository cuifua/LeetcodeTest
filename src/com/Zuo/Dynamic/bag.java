package com.Zuo.Dynamic;

import org.junit.Test;

/*
����Ŀ���������ҳ���ģ�͢�
    �����������ȶ�ΪN������Weights��values
    weights[i] �� values[i]�ֱ����i����Ʒ�������ͼ�ֵ
    ����һ������bag,��ʾһ������bag�Ĵ���
    ��װ����Ʒ���ܳ����������
    ������װ�µ����ļ�ֵ�Ƕ���
 */
public class bag
{
    //1�������ݹ鷨
    public int getMaxValue(int[] w, int[] v, int bag)
    {
        //return dfs1(w,v,0,0,bag);
        return dfs2(w,v,0,bag);
    }

    /*
    ����ģ�int[] w, int[] v,int bag
    index����ֵ,ѡ��Ҫ���߲�Ҫ
    0...index-1 �����˻����ѡ��ʹ�����Ѿ��ﵽ�������Ƕ���alreadyW
    �������-1����Ϊû�з���
    ���������-1����Ϊ���ص�ֵ����ʵ��ֵ
     */
    public int dfs1(int[] w, int[] v, int index, int alreadyW, int bag)
    {
        if(alreadyW > bag)
            return -1;

        if(index == w.length)
            return 0;

        int p1 = dfs1(w,v,index+1,alreadyW,bag);//����������alreadyW,��ʾû��Ҫ��ǰ�Ļ�
        int p2next = dfs1(w,v,index+1,alreadyW+w[index],bag);//����alreadyW+w[index],��ʾҪ�˵�ǰ�Ļ�

        int p2 = -1;
        if(p2next != -1)
            p2 = v[index]+p2next;

        return Math.max(p1,p2);
    }

    /*
    ֻʣ��rest�Ŀռ���
    index...��������ѡ�񣬵�ʣ��ռ䲻ҪС��0
    ����index...�����ܻ�õ�����ֵ
    */
    public int dfs2(int[] w, int[] v, int index, int rest)
    {
        if(rest <= 0)
            return -1;

        if(index == w.length)//index���������ֹλ�ã�����0�ļ�ֵ
            return 0;

        int p1 = dfs2(w,v,index+1,rest); //��Ҫindexλ���ϵĻ���
        int p2next = dfs2(w,v,index+1,rest-w[index]);//Ҫindexλ���ϵĻ���

        int p2 = -1;
        if(p2next != -1)
            p2 = v[index]+p2next;

        return Math.max(p1,p2);
    }



    //3����̬�滮��
    public int getMaxValueDynamic(int[] w, int[] v, int bag)
    {
        int N = w.length;
        int[][] dp = new int[N+1][bag+1];

        for (int index = N-1; index >= 0 ; index--)//�������������
        {
            for (int rest = 0; rest <= bag ; rest++)//restʣ���Ǵ�������
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
