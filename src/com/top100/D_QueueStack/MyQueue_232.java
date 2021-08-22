package com.top100.D_QueueStack;

import java.util.Stack;

/**
 * ����Ŀ��
 *      �����ʹ������ջʵ�������ȳ����С�����Ӧ��֧��һ�����֧�ֵ����в�����push��pop��peek��empty����
 *      ʵ�� MyQueue �ࣺ
 *      void push(int x) ��Ԫ�� x �Ƶ����е�ĩβ
 *      int pop() �Ӷ��еĿ�ͷ�Ƴ�������Ԫ��
 *      int peek() ���ض��п�ͷ��Ԫ��
 *      boolean empty() �������Ϊ�գ����� true �����򣬷��� false
 * �����⡿
 * ��˼·��
 */
public class MyQueue_232
{
    private Stack<Integer> in;// ����ջ
    private Stack<Integer> out;// ���ջ

    public MyQueue_232()
    {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x)
    {
        in.push(x);
    }

    public int pop()
    {
        // ���outջΪ�գ���inջȫ��������ѹ��outջ�У�Ȼ��out.pop()
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek()
    {
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty()
    {
        return in.isEmpty() && out.isEmpty();
    }
}
