package com.top100.z_ACM;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/4 12:22
 * @Version 1.0
 */
/*
��������:
    ���������У���һ��n
    �ڶ�����n���ո�������ַ���
�������:
    ���һ���������ַ������ո�������޽�β�ո�

����
    5
    c d a bb e
���
    a bb c d e
 */
public class H_StrSort
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        String[] list = sc.nextLine().split(" ");
        Arrays.sort(list);
        for(int i = 0; i < num; i++)
            System.out.print(list[i]+" ");
    }
}
