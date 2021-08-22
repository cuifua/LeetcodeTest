package com.top100.D_QueueStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����Ŀ��
 *      �����ʹ����������ʵ��һ�������ȳ���LIFO����ջ����֧����ͨջ��ȫ�����ֲ�����push��top��pop �� empty����
 *      ʵ�� MyStack �ࣺ
 *
 *      void push(int x) ��Ԫ�� x ѹ��ջ����
 *      int pop() �Ƴ�������ջ��Ԫ�ء�
 *      int top() ����ջ��Ԫ�ء�
 *      boolean empty() ���ջ�ǿյģ����� true �����򣬷��� false ��
 * �����⡿
 * ��˼·��
 */
class MyStack_225
{
    private Queue<Integer> in;//�������
    private Queue<Integer> out;//�������

    public MyStack_225()
    {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(int x)
    {
        in.offer(x);
        // ��b������Ԫ��ȫ��ת��a����
        while(!out.isEmpty())
            in.offer(out.poll());
        // ����a��b,ʹ��a����û����push()��ʱ��ʼ��Ϊ�ն���
        Queue temp = in;
        in = out;
        out = temp;
    }

    public int pop()
    {
        return out.poll();
    }

    public int top()
    {
        return out.peek();
    }

    public boolean empty()
    {
        return out.isEmpty();
    }
}
