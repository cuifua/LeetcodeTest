package com.top100.z_ACM;

import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/4 12:21
 * @Version 1.0
 */
/*
��������:
    ���������ж���, ÿ�б�ʾһ���������ݡ�
    ÿ�еĵ�һ������Ϊ�����ĸ���n(1 <= n <= 100)��
    ������n��������, ����Ҫ��͵�ÿ����������
�������:
    ÿ�����������͵Ľ��
����
    4 1 2 3 4
    5 1 2 3 4 5
���
    10
    15
 */
public class F_AaddB
{
    public static void main(String[] ars)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            int n = sc.nextInt();
            int sum =0;

            for (int i = 0;i < n; i++)
                sum += sc.nextInt();

            System.out.println(sum);
        }
    }
}
