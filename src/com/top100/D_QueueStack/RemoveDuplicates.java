package com.top100.D_QueueStack;

import java.util.Stack;

/*
����Ŀ�� ������Сд��ĸ��ɵ��ַ���S���ظ���ɾ��������ѡ��������������ͬ����ĸ����ɾ�����ǡ�
        �� S �Ϸ���ִ���ظ���ɾ��������ֱ���޷�����ɾ����
        ����������ظ���ɾ�������󷵻����յ��ַ������𰸱�֤Ψһ��
�����⡿ ���룺"abbaca"
        �����"ca"
        ���ͣ�
        ���磬�� "abbaca" �У����ǿ���ɾ�� "bb" ��������ĸ��������ͬ�����Ǵ�ʱΨһ����ִ��ɾ���������ظ��
        ֮�����ǵõ��ַ��� "aaca"��������ֻ�� "aa" ����ִ���ظ���ɾ�����������������ַ���Ϊ "ca"��
*/
public class RemoveDuplicates
{
    public String remove (String s)
    {
        Stack<Character> help = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (!s.isEmpty() && help.peek() == s.charAt(i)) help.pop();
            else  help.push(s.charAt(i));
        }

        StringBuffer sb = new StringBuffer();
        for (Character c : help)
            sb.append(c);
        return sb.toString();
    }
}
