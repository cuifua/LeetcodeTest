package com.top100.z_ACM;

import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/4 12:20
 * @Version 1.0
 */
/*
��������:
    �����������������a,b(1 <= a, b <= 10^9),���������ж���, �������Ϊ0 0���������
�������:
    ���a+b�Ľ��

����
    1 5
    10 20
    0 0
���
    6
    30
 */
public class C_AaddB
{
    public static void main(String[] args)
    {
        Scanner sca = new Scanner(System.in);
        while(sca.hasNext())
        {
            int a = sca.nextInt();
            int b = sca.nextInt();

            if(a==0 && b==0)
                break;
            else
                System.out.println(a+b);
        }
    }
}
