package com.top100.C_String.Reverse;

import org.junit.Test;

/*
【题目】字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
       请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
【例题】 输入: s = "abcdefg", k = 2
        输出:"cdefgab"
        示例 2：

        输入: s = "lrloseumgh", k = 6
        输出:"umghlrlose"
*/
public class ReverseLeftWords_off58II
{
    public String reserveLeft(String s, int n)
    {
        char[] str = s.toCharArray();
        reserve(str,0,n-1);
        reserve(str, n,s.length()-1);
        reserve(str,0,s.length()-1);

        return new String(str);
    }
    public void reserve (char[] ch, int i, int j)
    {
       while(i < j)
       {
           char temp = ch[i];
           ch[i] = ch[j];
           ch[j] = temp;
           i++;
           j--;
       }
    }

    @Test
    public void test()
    {
        System.out.println(reserveLeft("abefg", 2));
    }
}

