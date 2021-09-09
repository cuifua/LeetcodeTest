package com.top100.C_String.Palindrome;
/*
 * 【题目】
 *      给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *      具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 【例题】
 *      输入："abc"
 *      输出：3
 *      解释：三个回文子串: "a", "b", "c"
 *
 *      输入："aaa"
 *      输出：6
 *      解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * 【思路】
 *      从字符串的某一位开始，尝试着去扩展子字符串。
 *      比如寻找aaa，
 *      先找奇数长度，a->a->aaa->a
 *      再找偶数长度，aa->aa
 */
public class countSubstrings_647
{
    int cnt = 0;

    public int countSubstrings(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            help(s, i, i);          //寻找奇数长度的回文
            help(s, i, i + 1); //寻找偶数长度的回文
        }
        return cnt;
    }

    //在某一处扩展寻找
    void help(String s, int start, int end)
    {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end))
        {
            start--;
            end++;

            cnt++;
        }
    }
}
