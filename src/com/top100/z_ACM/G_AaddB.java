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
    ÿ�в�����n���������ո������(1 <= n <= 100)��
�������:
    ÿ�����������͵Ľ��
����
    1 2 3
    4 5
    0 0 0 0 0
���
    6
    9
    0
 */
public class G_AaddB
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            String [] str = sc.nextLine().split(" ");
            int sum = 0;
            for(String num :str)
                sum += Integer.parseInt(num);

            System.out.println(sum);
        }
    }
}
