package com.top100.D_QueueStack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
����Ŀ��  ���� �沨����ʾ��������ʽ��ֵ��
        ��Ч���������+��-��*��/��ÿ��������������������Ҳ��������һ���沨�����ʽ��
        ��������ֻ�����������֡�
        �����沨�����ʽ������Ч�ġ����仰˵�����ʽ�ܻ�ó���Ч��ֵ�Ҳ����ڳ���Ϊ 0 �������
�����⡿
        ���룺tokens = ["2","1","+","3","*"]
        �����9
        ���ͣ�����ʽת��Ϊ��������׺�������ʽΪ��((2 + 1) * 3) = 9��

        ���룺tokens = ["4","13","5","/","+"]
        �����6
        ���ͣ�����ʽת��Ϊ��������׺�������ʽΪ��(4 + (13 / 5)) = 6

        ���룺tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        �����22
        ���ͣ�
        ����ʽת��Ϊ��������׺�������ʽΪ��
          ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
        = ((10 * (6 / (12 * -11))) + 17) + 5
        = ((10 * (6 / -132)) + 17) + 5
        = ((10 * 0) + 17) + 5
        = (0 + 17) + 5
        = 17 + 5
        = 22
 */
public class evalBPN
{
    public int eval(String[] tokens)
    {
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = tokens.length;

        for (int i = 0; i < n; i++)
        {
            String token = tokens[i];
            if (isNumber(token))
                stack.push(Integer.parseInt(token));

            else
            {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token)
                {
                    case "+":
                        stack.push(num1 + num2);
                        break;

                    case "-":
                        stack.push(num1 - num2);
                        break;

                    case "*":
                        stack.push(num1 * num2);
                        break;

                    case "/":
                        stack.push(num1 / num2);
                        break;

                    default:
                }
            }
        }
        return stack.pop();
    }
    public boolean isNumber(String token)
    {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }





    @Test
    public void test()
    {
        System.out.println(eval(new String[] {"4","2","+","3","*"}));
    }
}

