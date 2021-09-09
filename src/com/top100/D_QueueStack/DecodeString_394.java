package com.top100.D_QueueStack;

import java.util.Stack;

/*
����Ŀ��
    ����һ������������ַ������������������ַ�����
    �������Ϊ: k[encoded_string]����ʾ���з������ڲ��� encoded_string �����ظ� k �Ρ�ע�� k ��֤Ϊ��������
    �������Ϊ�����ַ���������Ч�ģ������ַ�����û�ж���Ŀո�������ķ��������Ƿ��ϸ�ʽҪ��ġ�
    ���⣬�������Ϊԭʼ���ݲ��������֣����е�����ֻ��ʾ�ظ��Ĵ��� k �����粻�������3a��2[4]�����롣
��ʾ����
    ���룺s = "3[a]2[bc]"
    �����"aaabcbc"
��ʾ����
    ���룺s = "3[a2[c]]"
    �����"accaccacc"
 */
public class DecodeString_394
{
    public String decodeString(String s)
    {
        int len = s.length();
        int i = 0;
        Stack<String> stack = new Stack<>();

        while ( i < len)
        {
            String sub = s.substring(i , i + 1);
            if (sub.equals("]") ) // ���� ]������ �� ��ǰ����ַ�ȫ����������ѭ��n�Σ���ѹ��ջ
            {
                StringBuffer stringSb = new StringBuffer();//��1��--------���ַ���---------��
                while (isStr(stack.peek()))
                    stringSb.append( stack.pop() );


                stack.pop() ; // ������Ӧ��������[


                StringBuffer NumSb = new StringBuffer();//��2��--------������---------��
                while (! stack.isEmpty() && isNum(stack.peek()))
                    NumSb.append(stack.pop());


                NumSb.reverse();
                int times = Integer.valueOf(NumSb.toString());//�������ַ�ת����int



                StringBuffer subs = new StringBuffer();//��3��--------�����ֺ���ĸƴ�Ӻ����ʱ�ַ���---------��
                while ( times -- > 0)
                    subs.append(stringSb);

                stack.push(subs.toString());

                i ++;
            }
            else
            {
                stack.push(sub);
                i ++;
            }
        }

        StringBuffer res = new StringBuffer();//��4��--------�����յĽ��---------��
        while (! stack.isEmpty() )
            res.append(stack.pop());

        res.reverse();
        return res.toString();
    }

    private boolean isStr(String sub)
    {
        char c = sub.charAt(0);
        return (  c - 'a' >= 0   && c - 'z' <= 0 );
    }

    private boolean isNum(String sub)
    {
        char c = sub.charAt(0);
        return ( c - '0' >= 0  && c - '9' <= 0);
    }
}
