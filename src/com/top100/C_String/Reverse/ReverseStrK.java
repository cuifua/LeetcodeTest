package com.top100.C_String.Reverse;

import org.junit.Test;

/*
【题目】 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔2k 个字符的前 k 个字符进行反转。
        如果剩余字符少于 k 个，则将剩余字符全部反转。
        如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

        输入: s = "abcdefg", k = 2
        输出: "bacdfeg"
 */
public class ReverseStrK
{
    public String reverseStr(String s, int k)
    {
        char [] ch = s.toCharArray();
        int n = ch.length;

        for(int i = 0; i < n; i += 2 * k)
        {
            int L = i;
            int R = (i + k - 1) < n ? i + k - 1 : n - 1;

            while(L <= R)
            {
                char tmp = ch[L];
                ch[L] = ch[R];
                ch[R] = tmp;

                L++;
                R--;
            }
        }
        return new String(ch);
    }

    @Test
    public void test()
    {
        System.out.println(reverseStr("abcdef",2));
    }
}

