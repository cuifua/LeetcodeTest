package com.Company.MeituanII;

/**
 * @Author cuifua
 * @Date 2021/8/23 13:25
 * @Version 1.0
 */
/*
ţţ���һ���������ɴα任��ֱ�������ֻʣ��һλ���֡�
�任�Ĺ����ǣ����������� ����λ���ϵ����ֵĳ˻�������285����һ�α任��ת����2*8*5=80.
�����ǣ�Ҫ�����ٴα任��ʹ���������ɸ�λ����

��������:
����һ����������С�ڵ���2,000,000,000��

�������:
���һ����������ʾ�任������

��������1:
285

�������1:
2
 */
import java.util.Scanner;

public class Main_5
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextInt();

        int count = 0;
        long temp = 1;

        while (num / 10 != 0)
        {
            //ÿ����������ת���ַ���
            //String s=Double.toString(num);
            //ѭ����ȡ�˻�
            count++;
            while (num % 10 != 0 || String.valueOf(num).length()>1)
            {
                long now= num % 10;
                num=num/10;
                temp = temp * now;
            }
            num = temp;
            temp = 1;
        }
        System.out.println(count);
    }
}
