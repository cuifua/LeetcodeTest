package com.top100.z_ACM;

import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/4 12:21
 * @Version 1.0
 */
/*
����������
    ����ĵ�һ�а���һ��������t(1 <= t <= 100), ��ʾ����������
    ������t��, ÿ��һ�����ݡ�
    ÿ�еĵ�һ������Ϊ�����ĸ���n(1 <= n <= 100)��
    ������n��������, ����Ҫ��͵�ÿ����������
�������:
    ÿ�����������͵Ľ��

����
    2
    4 1 2 3 4
    5 1 2 3 4 5
���
    10
    15
 */
public class E_AaddB
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            int count = sc.nextInt();
            int sum = 0;
            for (int j = 0; j < count; j++)
                sum += sc.nextInt();

            System.out.println(sum);
        }
    }
}
