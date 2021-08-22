package com.top100.B_Hash.map;
/*
����Ŀ�����������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�

�����⡿ ʾ��1:
        ����: s = "anagram", t = "nagaram"
        ���: true

        ʾ�� 2:
        ����: s = "rat", t = "car"
        ���: false
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

        //�����ڶ����ַ�������Ȼ��ÿ���������ַ�����map�����Ƚ�
        //�������ַ�����map����֣�����map�ｫ������ֵ��ַ�������1��������ȥ
        for(char str : t.toCharArray())
        {
            if(map.containsKey(str))
                map.put(str,map.get(str)-1);
            else
                map.put(str,1);
        }

        //�������ڵ��ַ���������ַ����ﻹ�����֣���ô˵������Ҫ�Ƚϵ��ַ�������ȣ�����false
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



