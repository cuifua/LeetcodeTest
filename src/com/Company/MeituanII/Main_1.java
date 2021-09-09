package com.Company.MeituanII;

/**
 * @Author cuifua
 * @Date 2021/8/23 13:13
 * @Version 1.0
 */
/*
ţţ��һ�����飬����������ܲ���ȣ���������������Ϊ�����е�������ȡ����Ƿ���С�
ţţ���Խ��еĲ����ǣ��������е�����һ������Ϊ�������������
���������ʹ�ô������ޣ�Ҳ���Բ�ʹ�ã����ҿ��Զ�ͬһ��λ��ʹ�ö�Ρ�

��������:
����һ��������N (N <= 50)
������һ������N����������ÿ������С�ڵ���1e9.

�������:
���羭�����ɴβ�������ʹ��N��������ȣ���ô���"YES", �������"NO"

��������1:
2
1 2

�������1:
YES
 */
/*
����֪ʶ��Ӧ���ǿ�����ж�һ��������2��ָ����

����YES��������֪��������ʽ�ֽ��ֻ��2�ĸ�����ͬ.
���һ��forѭ�����������������ô�������С�����õ��̺�����.
����̲���2���ݣ���������������0������ֹѭ�������NO��

֤�����Ƿ�2��ָ���ݣ�����ʹ�ö����ƹ��ɣ�2��ָ���ݶ�Ӧ�Ķ�������1�ĸ���Ϊ1.
��˿���ͨ�� n & (n-1) == 0 �ж����Ƿ�2��ָ���ݡ���8&7==0, 16&15=0
 */

import java.util.*;
public class Main_1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];

        for(int i = 0 ; i < n ; i++)
            a[i] = scanner.nextInt();

        for(int i = 1 ; i < n ; i++)
        {
            int small, big;

            if(a[i] > a[i-1])
            {
                small = a[i-1];
                big = a[i];
            }
            else
            {
                small = a[i];
                big = a[i-1];
            }

            int remainder = big % small;   //����
            int quotient = big / small;    //��

            if(remainder != 0 || (quotient & (quotient-1)) != 0)
            {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
