package com.top100.B_Hash.map;
/*
【题目】给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

【例题】 示例1:
        输入: s = "anagram", t = "nagaram"
        输出: true

        示例 2:
        输入: s = "rat", t = "car"
        输出: false
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class isAnagram_242
{
    public boolean isanagram(String s,String t)
    {
        //put the first string into map
        Map<Character,Integer> map = new HashMap<>();
        for(char str : s.toCharArray())
          map.put(str,map.getOrDefault(str,0)+1);

        //遍历第二个字符串，当然后将每个遍历的字符串和map里的相比较
        //如果这个字符串在map里出现，就在map里将这个出现的字符数量减1，遍历下去
        for(char str : t.toCharArray())
        {
            if(map.containsKey(str))
                map.put(str,map.get(str)-1);
            else
                map.put(str,1);
        }

        //遍历现在的字符串，如果字符串里还有数字，那么说明两个要比较的字符串不相等，返回false
        for(char num : map.keySet())
        {
            if(map.get(num) != 0)
                return false;
        }
        return true;
    }


    @Test
    public void test()
    {
        System.out.println(isanagram("eayhnt", "yanetk"));
    }
}

/*
/*
    public boolean isanagram(String s, String t)
    {
        if(s.length() != t.length())    return false;

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
  */



