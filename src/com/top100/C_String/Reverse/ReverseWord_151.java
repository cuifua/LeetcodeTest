package com.top100.C_String.Reverse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * ����Ŀ��
 *      ����һ���ַ��� s �������ת�ַ����е����� ���� ��
 *      ���� ���ɷǿո��ַ���ɵ��ַ�����s ��ʹ������һ���ո��ַ����е� ���� �ָ�����
 *      ���㷵��һ����ת s �е���˳���õ����ո��������ַ�����
 * �����⡿
 *      ���룺s = "the sky is blue"
 *      �����"blue is sky the"
 * ��˼·��
 *      1��ʹ�� split ���ַ������ո�ָ���ַ������飻
 *      2��ʹ�� reverse ���ַ���������з�ת��
 *      3��ʹ�� join �������ַ�������ƴ��һ���ַ�����
 */
public class ReverseWord_151
{
    public String reverseWords(String s)
    {
        // ��ȥ��ͷ��ĩβ�Ŀհ��ַ�
        s = s.trim();

        //1������ƥ�������Ŀհ��ַ���Ϊ�ָ����ָ�
        List<String> wordList = Arrays.asList(s.split("\\s+"));

        //2��ʹ�� reverse ���ַ���������з�ת��
        Collections.reverse(wordList);

        //3��ʹ�� join �������ַ�������ƴ��һ���ַ�����
        return String.join(" ", wordList);
    }
}
