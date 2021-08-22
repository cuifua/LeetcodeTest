package com.top100.C_String.DUIbI;
/*
 * 【题目】
 *      给定两个字符串s和t，判断它们是否是同构的。
 *      如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 *      每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 【例题】
 *      输入：s = "egg", t = "add"
 *      输出：true
 *
 *      输入：s = "foo", t = "bar"
 *      输出：false
 *
 *      输入：s = "paper", t = "title"
 *      输出：true
 * 【思路】
 *      记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构。
 */
public class isIsomorphic_205
{
    public boolean isIsomorphic(String s,String t)
    {
        int[] indexOfs = new int[256];
        int[] indexOft = new int[256];

        for(int i = 0; i < s.length(); i++)
        {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(indexOfs[sc] != indexOft[tc])
                return false;

            indexOfs[sc] = i + 1;
            indexOft[tc] = i + 1;
        }
        return true;
    }
}
