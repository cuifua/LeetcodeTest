package com.top100.I_Backtracking.combination;
//����Ŀ��    ����һ������������2-9���ַ����������������ܱ�ʾ����ĸ��ϡ��𰸿��԰� ����˳�� ���ء�
//           �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
//�����⡿    ���룺digits = "23"
//           �����["ad","ae","af","bd","be","bf","cd","ce","cf"]


import java.util.ArrayList;
import java.util.List;

public class LetterCombinations
{
    public List<String> letterCombinations(String digits)
    {
        if (digits == null || digits.length() == 0)
            return new ArrayList<String>();

        //һ��ӳ����ڶ���λ����"abc��,������λ����"def"������
        //����Ҳ������map����������Ը���ʡ���ڴ�
        String[] letter_map =
                {
                " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
                };

        List<String> res = new ArrayList<>();
        //���������м���һ�����ַ�
        res.add(" ");
        for (int i = 0; i < digits.length(); i++)
        {
            //�ɵ�ǰ���������ַ���ȡ�ֵ���в��Ҷ�Ӧ���ַ���
            String letters = letter_map[digits.charAt(i) - '0'];

            //��������г��Ⱥ󣬽������е�ÿ��Ԫ�ذ����ó���
            for (int j = 0; j < res.size(); j++)
            {
                //ÿ�ζ��Ӷ������ó���һ��Ԫ��
                String tmp = res.remove(0);

                //Ȼ���"def"�������ַ���ƴ�ӣ����ٴηŵ�������
                for (int k = 0; k < letters.length(); k++)
                    res.add(tmp + letters.charAt(k));
            }
        }
        return res;
    }
}
