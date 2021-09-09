package com.top100.D_QueueStack;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*
 【题目】
        给定一个只包括 '('，')'，'{'，'}'，'['，']'?的字符串 s ，判断字符串是否有效。
        有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
【例题】
        输入：s = "()"
        输出：true

        输入：s = "()[]{}"
        输出：true

        输入：s = "(]"
        输出：false
 【思路】
        用栈实现。如果是左括号直接压入栈，如果遇到右括号则弹出一个，如果不匹配直接输出false，如果匹配则继续。
*/
//利用栈先进后出 stack 局部变量
//当stack 压栈不成功后 后进去的括号自动弹出来 循环一次弹出一次
//c!=stack.pop() 取反 相等就自动弹栈 一直弹到没有说明对上了
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




