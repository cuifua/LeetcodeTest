package com.Zuo.Dynamic;

import org.junit.Test;

/*
����Ŀ����Χ�ϳ��Ե�ģ�͢�
    ����һ����������arr,������ֵ��ͬ��ֽ���ų�һ����
    ���A�����B��������ÿ��ֽ��
    1���涨���A���ã����B����
    2������ÿ�����ÿֻ��������������ҵ�ֽ��
    ���A�����B�������������뷵������ʤ�ߵķ���
��˼·��
    70 100 1 4
    ����A���ã�A�������70���ͻὫ100��¶��B�ˣ�����A��4

    70 100 1
    ����B�ã�BҲ�����100��¶��A������100���Ҷ��ᱩ¶��ֻ��ѡ��һ���Ƚϴ��70

    100 1
    ����A�ã��Ļ��A������100

    Bֻ����1 �����A104��B71��AӮ
 */
public class CardWin
{
    //1�������ݹ鷨
    public int win(int[] arr)
    {
        if(arr == null || arr.length == 0)
            return 0;

        //�������֡�������0---arr.length-1��Χ�ϵķ��ص����ֵ
        return Math.max(first(arr,0,arr.length-1),
                        second(arr,0,arr.length-1)
                       );
    }

    public int first(int[] arr, int L, int R)
    {
        if(R == L)
            return arr[L];//��ʣһ���Ƶ�ʱ�����������֣����������ƹ�����

        //�������������ߵģ�����ֻ����[L/L+1....R]����
        //������������ұߵģ�����ֻ����[L...R-1/R]����
        return Math.max(arr[L]+ second(arr,L+1,R),
                        arr[R]+second(arr,L,R-1)
                       );
    }

    public int second(int[] arr, int L, int R)
    {
        if(L == R)
            return 0; //��Ϊ�Ǻ��֣�ʣһ���Ʊ���������

        return Math.min(first(arr,L+1,R),
                        first(arr,L,R-1)
                       );
    }





    //3����̬�滮��
    public int winDynamic(int[] arr)
    {
        if(arr == null || arr.length == 0)
            return 0;

        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];

        for (int i = 0; i < N; i++)
            f[i][i] = arr[i];

        for (int i = 1; i < N; i++)
        {
            int L = 0;
            int R = i;

            while(L < N && R < N)
            {
                f[L][R] = Math.max(
                        arr[L]+ s[L+1][R],
                        arr[R]+s[L][R-1]
                );

                s[L][R] = Math.min(
                        f[L+1][R],
                        f[L][R-1]
                );

                L++;
                R++;
            }
        }

        return Math.max(f[0][N-1],s[0][N-1]);
    }






    @Test
    public void test()
    {
        int[] arr = {4,7,9,5,19,29,80,4};
        System.out.println(win(arr));
        System.out.println(winDynamic(arr));
    }
}
