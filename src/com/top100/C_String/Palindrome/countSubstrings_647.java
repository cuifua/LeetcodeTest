package com.top100.C_String.Palindrome;
/*
 * ����Ŀ��
 *      ����һ���ַ�������������Ǽ�������ַ������ж��ٸ������Ӵ���
 *      ���в�ͬ��ʼλ�û����λ�õ��Ӵ�����ʹ������ͬ���ַ���ɣ�Ҳ�ᱻ������ͬ���Ӵ���
 * �����⡿
 *      ���룺"abc"
 *      �����3
 *      ���ͣ����������Ӵ�: "a", "b", "c"
 *
 *      ���룺"aaa"
 *      �����6
 *      ���ͣ�6�������Ӵ�: "a", "a", "a", "aa", "aa", "aaa"
 * ��˼·��
 *      ���ַ�����ĳһλ��ʼ��������ȥ��չ���ַ�����
 *      ����Ѱ��aaa��
 *      �����������ȣ�a->a->aaa->a
 *      ����ż�����ȣ�aa->aa
 */
public class countSubstrings_647
{
    int cnt = 0;

    public int countSubstrings(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            help(s, i, i);          //Ѱ���������ȵĻ���
            help(s, i, i + 1); //Ѱ��ż�����ȵĻ���
        }
        return cnt;
    }

    //��ĳһ����չѰ��
    void help(String s, int start, int end)
    {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end))
        {
            start--;
            end++;

            cnt++;
        }
    }
}
