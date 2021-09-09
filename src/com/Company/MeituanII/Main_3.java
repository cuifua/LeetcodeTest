package com.Company.MeituanII;

/**
 * @Author cuifua
 * @Date 2021/8/23 13:23
 * @Version 1.0
 */
/*
ţţ������һ��n������ɵ�����,ţţ������ȡһ��������������,������������л����������:
    ���ֻ�ı�һ����,�Ϳ���ʹ�������������������һ���ϸ�������������,ţţ��֪�����������������ĳ����Ƕ��١�

��������:
�����������,��һ�а���һ������n(1 �� n �� 10^5),�����еĳ���;
�ڶ���n������a_i, ��ʾ�����е�ÿ����(1 �� a_i �� 10^9),�Կո�ָ

�������:
���һ������,��ʾ��ĳ��ȡ�

��������1:
6
7 2 3 1 5 6

�������1:
5
 */
import java.util.*;

public class Main_3
{
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            int N = sc.nextInt();
            int[] a = new int[N];
            int[] maxLen = new int[N];

            for(int i=0 ; i<N ; i++)
                a[i] = sc.nextInt();

            //��a[0]���⴦��
            if (a[1] >= 2)
            {
                maxLen[0] = 2;
                for (int i = 2; i < N; i++)
                {
                    if (a[i] > a[i - 1])
                        maxLen[0]++;
                    else
                        break;
                }
            }
            //��a[N-1]���⴦��
            maxLen[N - 1] = 2;
            for (int i = N - 2; i >= 0; i--)
            {
                if (a[i] > a[i - 1])
                    maxLen[N - 1]++;
                else
                    break;
            }

            //�Ա����1~N-2�Ľ��д���
            for (int i = 1; i <= N - 2; i++)
            {
                if (a[i + 1] - a[i - 1] >= 2)
                {
                    maxLen[i] = 3;
                    for (int j = i - 1; j > 0; j--)
                    {
                        if (a[j] > a[j - 1])
                            maxLen[i]++;
                        else
                            break;
                    }
                    for (int j = i + 1; j < N-1; j++)
                    {
                        if (a[j + 1] > a[j])
                            maxLen[i]++;
                        else
                            break;
                    }
                }
                else
                    maxLen[i] = 2;
            }
            Arrays.sort(maxLen);
            System.out.println(maxLen[N-1]);
        }
    }

}