package com.top100.D_QueueStack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/*
 * ����Ŀ��
 *      ���һ��֧�� push ��pop ��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ
 * ��˼·��
 *      https://leetcode-cn.com/problems/min-stack/solution/zui-xiao-zhan-by-leetcode-solution/
 *      �������������װ�
 */

public class MinStack_155
{
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack_155()
    {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x)
    {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));//minStack��������ͼ���Ҫ��ջ�����ֶԱȣ�������С�Ĳŷ���MinStack
    }

    public void pop()
    {
        xStack.pop();
        minStack.pop();
    }

    public int top()
    {
        return xStack.peek();
    }

    public int getMin()
    {
        return minStack.peek();
    }




    @Test
    public void test()
    {
        MinStack_155 ms = new MinStack_155();
        {
            ms.push(-2);
            ms.push(-3);
            ms.push(4);
            ms.push(7);

            System.out.println(ms.getMin());

            ms.pop();
            System.out.println(ms.top());
            System.out.println(ms.getMin());
        }
    }
}
