package com.top100.C_String.DUIbI;

/*
 * 【题目】
 *      给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 【例题】
 *      输入: s = "anagram", t = "nagaram"
 *      输出: true
 *
 *      输入: s = "rat", t = "car"
 *      输出: false
 * 【思路】
 *      没啥思路，看代码
 */
public class isAnagram_242
{
    public boolean isAnagram(String s, String t)
    {
        int[] cnts = new int[26];
        for (char c : s.toCharArray())
            cnts[c - 'a']++;

        for (char c : t.toCharArray())
            cnts[c - 'a']--;

        for (int cnt : cnts)
        {
            if (cnt != 0)
                return false;
        }
        return true;
    }
}
