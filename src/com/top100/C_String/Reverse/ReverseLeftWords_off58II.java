package com.top100.C_String.Reverse;

import org.junit.Test;

/*
����Ŀ���ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β����
       �붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ����磬�����ַ���"abcdefg"������2���ú�������������ת��λ�õ��Ľ��"cdefgab"��
�����⡿ ����: s = "abcdefg", k = 2
        ���:"cdefgab"
        ʾ�� 2��

        ����: s = "lrloseumgh", k = 6
        ���:"umghlrlose"
*/
public class ReverseLeftWords_off58II
{
    public String reserveLeft(String s, int n)
    {
        char[] str = s.toCharArray();
        reserve(str,0,n-1);
        reserve(str, n,s.length()-1);
        reserve(str,0,s.length()-1);

        return new String(str);
    }
    public void reserve (char[] ch, int i, int j)
    {
       while(i < j)
       {
           char temp = ch[i];
           ch[i] = ch[j];
           ch[j] = temp;
           i++;
           j--;
       }
    }

    @Test
    public void test()
    {
        System.out.println(reserveLeft("abefg", 2));
    }
}

