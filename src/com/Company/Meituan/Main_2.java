package com.Company.Meituan;

/**
 * @Author cuifua
 * @Date 2021/9/2 16:47
 * @Version 1.0
 */
/*
���ǳ�һ������Ϊn������Ϊ�������У����ҽ�����������һ����1~n��ɵ����У�����������n����������ɣ�ȡֵ��[1,n]��Χ���Ҳ������ظ�������ͬʱ�������в�Ҫ������
��һ��С�ŵõ���һ������Ϊn���������У�����Ҫ�����޴β����ڣ���������б��һ���������У�ÿ�β�����������ѡ�����е�һ�����֣����������ּ�һ���߼�һ��
�����������ö��ٴβ������԰�������б���������У�


��������:
�����һ�н�����һ��������n����ʾ�������еĳ��ȡ�(1<=n<=20000)
����ڶ��а���n����������ʾ���������У�ÿ�����ľ���ֵ��С��10000��

�������:
���������һ����������ʾ���ٵĲ���������


��������1:
5
-1 2 3 10 100

�������1:
103
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main_2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();

        Arrays.sort(arr);//�Ѿ��ź����ˣ���ôʣ�µ���Щ���ֲ��ڿ�λ�Ϳ���ֱ�Ӽ�����
        int res=0;

        for(int i=0; i<n; i++)
            res += Math.abs(arr[i]-(i+1));//�����Ĵ��������Լ������ֵ���±�Ĳ�ֵ

        System.out.println(res);
    }
}