package com.top100.D_QueueStack;

import java.util.Stack;

/*
【题目】
    给定一个经过编码的字符串，返回它解码后的字符串。
    编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
    你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
    此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
【示例】
    输入：s = "3[a]2[bc]"
    输出："aaabcbc"
【示例】
    输入：s = "3[a2[c]]"
    输出："accaccacc"
 */
public class DecodeString_394
{
    public String decodeString(String s)
    {
        int len = s.length();
        int i = 0;
        Stack<String> stack = new Stack<>();

        while ( i < len)
        {
            String sub = s.substring(i , i + 1);
            if (sub.equals("]") ) // 遇到 ]右括号 ， 将前面的字符全部弹出，并循环n次，再压入栈
            {
                StringBuffer stringSb = new StringBuffer();//【1、--------放字符串---------】
                while (isStr(stack.peek()))
                    stringSb.append( stack.pop() );


                stack.pop() ; // 弹出对应的左括号[


                StringBuffer NumSb = new StringBuffer();//【2、--------放数字---------】
                while (! stack.isEmpty() && isNum(stack.peek()))
                    NumSb.append(stack.pop());


                NumSb.reverse();
                int times = Integer.valueOf(NumSb.toString());//将数字字符转换成int



                StringBuffer subs = new StringBuffer();//【3、--------放数字和字母拼接后的临时字符串---------】
                while ( times -- > 0)
                    subs.append(stringSb);

                stack.push(subs.toString());

                i ++;
            }
            else
            {
                stack.push(sub);
                i ++;
            }
        }

        StringBuffer res = new StringBuffer();//【4、--------放最终的结果---------】
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
