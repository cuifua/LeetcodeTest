package com.top100.D_QueueStack;

import java.util.Collections;
import java.util.LinkedList;
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

    ���룺s = "3[a2[c]]"
    �����"accaccacc"
��˼·��
    ��ʱջ��
    ���֣�
    ��ĸ��

    ��ʼ��������һ���ַ���3�������ַŵ�������
    ��ʱջ��
    ���֣�3
    ��ĸ������

    �ڶ����ַ���[�������������žͰѸյ���Щ�Ž���ʱջȻ����գ��������к���ĸ�зŽ���ʱջ������к���ĸ�����
    ��ʱջ����3������
    ���֣�
    ��ĸ��

    �������ַ���a ,������ĸ��
    ��ʱջ����3������
    ���֣�
    ��ĸ��a

    ���ĸ��ַ���2������������
    ��ʱջ����3������
    ���֣�2
    ��ĸ��a

    ������ַ�����[,�Ѹո���������ĸ�е����ݷŽ���ʱջȻ�����
    ��ʱջ����3������  ��2 a��
    ���֣�
    ��ĸ��

    �������ַ���c ������ĸ��
    ��ʱջ����3������  ��2 a��
    ���֣�c
    ��ĸ��

    ���߸��ַ���] ���Դ�β��ǰ�ĳ�ջ��
    ��ʱջ����3������
    ���֣�acc
    ��ĸ��

    �ڰ˸��ַ���] ���Դ�β��ǰ�ĳ�ջ��
    ��ʱջ��
    ���֣�accaccacc
    ��ĸ��
 */
public class StringCode_394
{
   int ptr;
   public String decodeString(String s)
   {
       LinkedList<String> stk = new LinkedList<String>();
       ptr = 0;

       while (ptr < s.length())
       {
           char cur = s.charAt(ptr);
           if (Character.isDigit(cur))
           {
               String digits = getDigits(s);// ��ȡһ�����ֲ���ջ
               stk.addLast(digits);
           }
           else if (Character.isLetter(cur) || cur == '[') // ��ȡһ����ĸ����ջ
           {
               stk.addLast(String.valueOf(s.charAt(ptr++)));
           }
           else
           {
               ++ptr;
               LinkedList<String> sub = new LinkedList<String>();
               while (!"[".equals(stk.peekLast()))
               {
                   sub.addLast(stk.removeLast());
               }
               Collections.reverse(sub);

               stk.removeLast();// �����ų�ջ
               int repTime = Integer.parseInt(stk.removeLast());// ��ʱջ��Ϊ��ǰ sub ��Ӧ���ַ���Ӧ�ó��ֵĴ���
               StringBuffer t = new StringBuffer();
               String o = getString(sub);

               while (repTime-- > 0)  // �����ַ���
                   t.append(o);

               stk.addLast(t.toString());// ������õ��ַ�����ջ
           }
       }

       return getString(stk);
   }

   public String getDigits(String s)
   {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr)))
            ret.append(s.charAt(ptr++));

        return ret.toString();
   }

   public String getString(LinkedList<String> v)
   {
        StringBuffer ret = new StringBuffer();
        for (String s : v)
            ret.append(s);
        return ret.toString();
   }
}


class Solution
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
            else{
                stack.push( sub );
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
