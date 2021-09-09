package com.top100.A_Array.MoveWindows;

import java.util.Arrays;
import java.util.HashMap;
/*
 * 【题目】
 *       给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *       换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * 【例题】
 *       输入: s1 = "ab" s2 = "eidbaooo"
 *       输出: True
 *       解释: s2 包含 s1 的排列之一 ("ba").
 */
public class minSubArrayLen_567
{
    public boolean checkInclusion(String s1, String s2)
        {
            int m = s1.length();
            int n = s2.length();
            if (m > n)
                return false;

            int[] cnt = new int[26];
            for (char c : s1.toCharArray())
                cnt[c - 'a']++;

            int[] cur = new int[26];
            for (int i = 0; i < m; i++)
                cur[s2.charAt(i) - 'a']++;

            if (check(cnt, cur))
                return true;

            for (int i = m; i < n; i++)
            {
                cur[s2.charAt(i) - 'a']++;
                cur[s2.charAt(i - m) - 'a']--;
                if (check(cnt, cur)) return true;
            }
            return false;
        }
        boolean check(int[] cnt1, int[] cnt2)
        {
            for (int i = 0; i < 26; i++)
            {
                if (cnt1[i] != cnt2[i])
                    return false;
            }
            return true;
        }
}



