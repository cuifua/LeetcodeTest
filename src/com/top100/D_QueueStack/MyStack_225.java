package com.top100.D_QueueStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 【题目】
 *      请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *      实现 MyStack 类：
 *
 *      void push(int x) 将元素 x 压入栈顶。
 *      int pop() 移除并返回栈顶元素。
 *      int top() 返回栈顶元素。
 *      boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * 【例题】
 * 【思路】
 */
class MyStack_225
{
    private Queue<Integer> in;//输入队列
    private Queue<Integer> out;//输出队列

    public MyStack_225()
    {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(int x)
    {
        in.offer(x);
        // 将b队列中元素全部转给a队列
        while(!out.isEmpty())
            in.offer(out.poll());
        // 交换a和b,使得a队列没有在push()的时候始终为空队列
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
