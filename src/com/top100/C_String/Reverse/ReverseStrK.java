package com.top100.C_String.Reverse;

import org.junit.Test;

/*
����Ŀ�� ����һ���ַ��� s ��һ������ k������Ҫ�Դ��ַ�����ͷ�����ÿ��2k ���ַ���ǰ k ���ַ����з�ת��
        ���ʣ���ַ����� k ������ʣ���ַ�ȫ����ת��
        ���ʣ���ַ�С�� 2k �����ڻ���� k ������תǰ k ���ַ��������ַ�����ԭ����

        ����: s = "abcdefg", k = 2
        ���: "bacdfeg"
 */
public class ReverseStrK
{
    public String reverseStr(String s, int k)
    {
        char [] ch = s.toCharArray();
        int n = ch.length;

        for(int i = 0; i < n; i += 2 * k)
        {
            int L = i;
            int R = (i + k - 1) < n ? i + k - 1 : n - 1;

            while(L <= R)
            {
                char tmp = ch[L];
                ch[L] = ch[R];
                ch[R] = tmp;

                L++;
                R--;
            }
        }
        return new String(ch);
    }

    @Test
    public void test()
    {
        System.out.println(reverseStr("abcdef",2));
    }
}

