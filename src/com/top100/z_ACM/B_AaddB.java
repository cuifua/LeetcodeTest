package com.top100.z_ACM;

import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/4 12:16
 * @Version 1.0
 */
/*
��������:
    �����һ�а���һ����������t(1 <= t <= 100)
    ������ÿ�а�������������a,b(1 <= a, b <= 10^9)
�������:
    ���a+b�Ľ��
ʾ��1

����
    2
    1 5
    10 20

���
    6
    30
 */
public class B_AaddB
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);
        }
    }
}
