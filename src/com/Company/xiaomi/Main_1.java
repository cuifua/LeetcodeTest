package com.Company.xiaomi;

import org.junit.Test;

import java.util.*;

/**
 * @Author cuifua
 * @Date 2021/9/2 17:41
 * @Version 1.0
 */
/*
给定一个长度为字符串, 需要去除所有之前曾经出现过的字符，只保留第一次出现的字符
 */
public class Main_1
{
    public String first(String s)
    {
        /*
        char[] ch = s.toCharArray();
        Map<Character,Boolean> map = new HashMap<>();

        for(char c : ch)
        {
            if(map.containsKey(c))
                map.put(c,false);
            else
                map.put(c,true);
        }

        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < ch.length; i++)
        {
            if(map.get(ch[i]))
                list.add(ch[i]);
        }

        char[] newchar = new char[list.size()];
        for(int i = 0; i < list.size(); i++)
            newchar[i++] = list.get(i);

        return new String(newchar);

         */
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray())
        {
            if(! set.contains(c))
            {
                set.add(c);
                sb.append(c);
            }

        }
        return new String(sb);
    }



    @Test
    public void test()
    {
        System.out.println(first("abbbbcdsss"));
    }
}
