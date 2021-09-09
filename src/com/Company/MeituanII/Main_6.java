package com.Company.MeituanII;

/**
 * @Author cuifua
 * @Date 2021/8/23 13:25
 * @Version 1.0
 */
/*
����һ������[a, b]�����������ڡ����������ĸ�����
�������Ķ��壺���ڲ�ͬλ�õ�������λ�����һ����λ�����Ҳ���ǰ��0�����������λ��Ϊ������
���磺153������ʹ������3������1���13��13��������������������ͬ��153�����ҵ�31��53ҲΪ������ֻҪ�ҵ�һ��������������������

��������:
����Ϊ��������a��b������[a, b]���� (1 �� a �� b �� 10000)��

�������:
���Ϊһ����������ʾ������������������������

��������1:
11 20

�������1:
6
 */
/*
����11��99���������������б�
��һ��ѭ����a��b�������� I ת�����ַ���S
�ڶ���ѭ���������б�ÿ��Ԫ�ز�������ַ�C1��C2��ͨ���ַ���S��indexOf����C1��C2��������ҵõ���Ϊ������
ֵ��ע��ط���������11����C1==C2�����֣������¼��ɡ�
 */
import java.util.*;

public class Main_6
{
    public static void main(String[] args)
    {
        List<Integer>list = new ArrayList<Integer>();
        for(int i=11;i<100;i++)
        {
            boolean isPrime = true;

            for(int j=2;j<=Math.sqrt(i);j++)
            {
                if(i%j==0)
                {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) list.add(i);
        }

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int cnt = 0;
        for(int i=a;i<=b;i++)
        {
            String s = String.valueOf(i);
            for(Integer e: list)
            {
                String s1 = String.valueOf(e/10);
                String s2 = String.valueOf(e%10);
                if(!s1.equals(s2))
                {
                    if(s.indexOf(s1)!=-1&&s.indexOf(s2)!=-1)
                    {
                        cnt++;
                        break;
                    }
                }
                else
                {
                    int index = s.indexOf(s1);
                    if(index!=-1&&s.indexOf(s2, index+1)!=-1)
                    {
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}