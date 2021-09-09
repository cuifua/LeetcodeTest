package com.top100.D_QueueStack;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*
 ����Ŀ��
        ����һ��ֻ���� '('��')'��'{'��'}'��'['��']'?���ַ��� s ���ж��ַ����Ƿ���Ч��
        ��Ч�ַ��������㣺
        �����ű�������ͬ���͵������űպϡ�
        �����ű�������ȷ��˳��պϡ�
�����⡿
        ���룺s = "()"
        �����true

        ���룺s = "()[]{}"
        �����true

        ���룺s = "(]"
        �����false
 ��˼·��
        ��ջʵ�֡������������ֱ��ѹ��ջ����������������򵯳�һ���������ƥ��ֱ�����false�����ƥ���������
*/
//����ջ�Ƚ���� stack �ֲ�����
//��stack ѹջ���ɹ��� ���ȥ�������Զ������� ѭ��һ�ε���һ��
//c!=stack.pop() ȡ�� ��Ⱦ��Զ���ջ һֱ����û��˵��������
public class IsVaild_20
{
    public boolean usvalid (String s)
    {
        if(s.isEmpty()) return true;
        Stack<Character> Mystack = new Stack<>();

        for(char c : s.toCharArray())
        {
            if( c == '(')
                Mystack.push(')');
            else if( c == '[')
                Mystack.push(']');
            else if( c == '{')
                Mystack.push('}');
            else if(Mystack.isEmpty() || c != Mystack.pop());
            return false;
        }
        return Mystack.isEmpty();
    }
}




