package com.top100.A_Array.MoveWindows;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*
����Ŀ��
    ����һ���ַ����������ҳ����в������ظ��ַ�����Ӵ��ĳ��ȡ�

�����⡿
    ����: s = "abcabcbb"
    ���: 3
    ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��

    ����: s = "bbbbb"
    ���: 1
    ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��

    ����: s = "pwwkew"
    ���: 3
    ����: ��Ϊ���ظ��ַ�����Ӵ���"wke"�������䳤��Ϊ 3��
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
