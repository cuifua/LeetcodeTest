package com.top100.D_QueueStack;

import java.util.Stack;

/**
 * 【题目】
 *      请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *      实现 MyQueue 类：
 *      void push(int x) 将元素 x 推到队列的末尾
 *      int pop() 从队列的开头移除并返回元素
 *      int peek() 返回队列开头的元素
 *      boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 【例题】
 * 【思路】
 */
public class MyQueue_232
{
    private Stack<Integer> in;// 输入栈
    private Stack<Integer> out;// 输出栈

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
        // 如果out栈为空，则将in栈全部弹出并压入out栈中，然后out.pop()
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
