package com.top100.z_ACM;

import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/4 12:16
 * @Version 1.0
 */
/*
��������:
    �����������������a,b(1 <= a, b <= 10^9),�������ݰ������顣
�������:
    ���a+b�Ľ��

ʾ��1
����
    1 5
    10 2

����
    6
    30
 */
public class A_AaddB
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }

}
