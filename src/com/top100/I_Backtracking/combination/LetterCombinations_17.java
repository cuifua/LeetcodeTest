package com.top100.I_Backtracking.combination;
//����Ŀ��    ����һ������������2-9���ַ����������������ܱ�ʾ����ĸ��ϡ��𰸿��԰� ����˳�� ���ء�
//           �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
//�����⡿    ���룺digits = "23"
//           �����["ad","ae","af","bd","be","bf","cd","ce","cf"]


import java.util.ArrayList;
import java.util.List;

public class LetterCombinations_17
{
    //����ȫ���б�洢���Ľ��
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits)
    {
        if (digits == null || digits.length() == 0)   return list;

        //��ʼ��Ӧ���е����֣�Ϊ��ֱ�Ӷ�Ӧ2-9��������������Ч���ַ���""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);//��������
        return list;
    }

    //ÿ�ε�����ȡһ���ַ��������Ի���ƴ������ַ���ƴ�ӣ���������ѡ���Ϊ��Ч�� StringBuild
    StringBuilder temp = new StringBuilder();

    //����digits���Ϊ"23",num Ϊ0����str��ʾ2��Ӧ�� abc
    public void backTracking(String digits, String[] numString, int num)
    {
        //����ȫ��һ�μ�¼һ�εõ����ַ���
        if (num == digits.length())
        {
            list.add(temp.toString());
            return;
        }

        //str ��ʾ��ǰnum��Ӧ���ַ���
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++)
        {
            temp.append(str.charAt(i));
            //c
            backTracking(digits, numString, num + 1);
            //�޳�ĩβ�ļ�������
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
