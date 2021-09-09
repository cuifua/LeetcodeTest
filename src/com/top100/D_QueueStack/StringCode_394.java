package com.top100.D_QueueStack;

import java.util.Collections;
import java.util.LinkedList;
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

    输入：s = "3[a2[c]]"
    输出："accaccacc"
【思路】
    临时栈：
    数字：
    字母：

    开始遍历，第一个字符是3，把数字放到数字列
    临时栈：
    数字：3
    字母：“”

    第二个字符是[，（遇到左括号就把刚的那些放进临时栈然后清空）把数字列和子母列放进临时栈里，数字列和字母列清空
    临时栈：【3“”】
    数字：
    字母：

    第三个字符是a ,放入字母列
    临时栈：【3“”】
    数字：
    字母：a

    第四个字符是2，放入数字列
    临时栈：【3“”】
    数字：2
    字母：a

    第五个字符又是[,把刚刚数字列字母列的内容放进临时栈然后清空
    临时栈：【3“”】  【2 a】
    数字：
    字母：

    第六个字符是c 放入字母列
    临时栈：【3“”】  【2 a】
    数字：c
    字母：

    第七个字符是] 可以从尾到前的出栈了
    临时栈：【3“”】
    数字：acc
    字母：

    第八个字符是] 可以从尾到前的出栈了
    临时栈：
    数字：accaccacc
    字母：
 */
public class StringCode_394
{
   int ptr;
   public String decodeString(String s)
   {
       LinkedList<String> stk = new LinkedList<String>();
       ptr = 0;

       while (ptr < s.length())
       {
           char cur = s.charAt(ptr);
           if (Character.isDigit(cur))
           {
               String digits = getDigits(s);// 获取一个数字并进栈
               stk.addLast(digits);
           }
           else if (Character.isLetter(cur) || cur == '[') // 获取一个字母并进栈
           {
               stk.addLast(String.valueOf(s.charAt(ptr++)));
           }
           else
           {
               ++ptr;
               LinkedList<String> sub = new LinkedList<String>();
               while (!"[".equals(stk.peekLast()))
               {
                   sub.addLast(stk.removeLast());
               }
               Collections.reverse(sub);

               stk.removeLast();// 左括号出栈
               int repTime = Integer.parseInt(stk.removeLast());// 此时栈顶为当前 sub 对应的字符串应该出现的次数
               StringBuffer t = new StringBuffer();
               String o = getString(sub);

               while (repTime-- > 0)  // 构造字符串
                   t.append(o);

               stk.addLast(t.toString());// 将构造好的字符串入栈
           }
       }

       return getString(stk);
   }

   public String getDigits(String s)
   {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr)))
            ret.append(s.charAt(ptr++));

        return ret.toString();
   }

   public String getString(LinkedList<String> v)
   {
        StringBuffer ret = new StringBuffer();
        for (String s : v)
            ret.append(s);
        return ret.toString();
   }
}


class Solution
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
            else{
                stack.push( sub );
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
