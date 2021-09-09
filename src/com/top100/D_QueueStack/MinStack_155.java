package com.top100.D_QueueStack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/*
 * 【题目】
 *      设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈
 * 【思路】
 *      https://leetcode-cn.com/problems/min-stack/solution/zui-xiao-zhan-by-leetcode-solution/
 *      看动画，明明白白
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
        minStack.push(Math.min(minStack.peek(), x));//minStack里最顶的数和即将要入栈的数字对比，两数中小的才放入MinStack
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
