package com.top100.z_ACM;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/4 12:23
 * @Version 1.0
 */
/*
��������:
    �������������ÿ����������һ�С�
    ÿ��ͨ��,��������n���ַ���n��100
�������:
    ����ÿ���������һ���������ַ�������','�������޽�β�ո�
����
    a,c,bb
    f,dddd
    nowcoder
���
    a,bb,c
    dddd,f
    nowcoder
 */
public class J_StrSort
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine())
        {
            String[] str = sc.nextLine().split(",");
            Arrays.sort(str);

            for(int i = 0; i < str.length; i++)
            {
                if (i == str.length - 1) System.out.print(str[i]);

                else System.out.print(str[i] + ",");
            }
        }
    }
}
