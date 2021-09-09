package com.top100.A_Array.MoveWindows;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*
【题目】
    给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。

【例题】
    输入: s = "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    输入: s = "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

    输入: s = "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 */

public class LongestSubstring
{
    public int longes(String s)
    {
        Map<Character, Integer> fin = new HashMap<>();
        int ans = 0;
        for (int end = 0, start = 0; end < s.length(); end++)
        {
            if (fin.containsKey(s.charAt(end)))
                start = Math.max(fin.get(s.charAt(end)), start);

            ans = Math.max(ans, end - start +1);
            fin.put(s.charAt(end), end + 1);
        }
        return ans;
    }



    @Test
    public void test()
    {
        String st = "abcwkkke";
        System.out.println(longes(st));
    }
}
