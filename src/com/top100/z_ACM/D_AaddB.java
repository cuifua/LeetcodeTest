package com.top100.z_ACM;

import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/4 12:21
 * @Version 1.0
 */
/*
��������:
    �������ݰ������顣
    ÿ������һ��,ÿ�еĵ�һ������Ϊ�����ĸ���n(1 <= n <= 100), nΪ0��ʱ��������롣
    ������n��������,����Ҫ��͵�ÿ����������
�������:
    ÿ�����������͵Ľ��

����
    4 1 2 3 4
    5 1 2 3 4 5
    0
���
    10
    15
 */
public class D_AaddB
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            int n = sc.nextInt();
            if(n == 0)   break;

            int sum = 0;
            for(int i = 0; i < n; i++)
                sum += sc.nextInt();

            System.out.println(sum);
        }
    }
}