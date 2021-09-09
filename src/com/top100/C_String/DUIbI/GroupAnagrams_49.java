package com.top100.C_String.DUIbI;
/*
����Ŀ��
    ����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
�����⡿
         ����: ["eat", "tea", "tan", "ate", "nat", "bat"]
         ���:
         [
            ["ate","eat","tea"],
            ["nat","tan"],
            ["bat"]
        ]
 */
import org.junit.Test;
import java.util.*;

class GroupAnagrams_49
{
    public List<List<String>> group(String[] strs)
    {
        if(strs == null || strs.length == 0)  return new ArrayList<>();
        Map <String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++)
        {
            char[] c = strs[i].toCharArray(); //ȡ���ַ�����Ȼ�����ת��Ϊ�ַ�����
            Arrays.sort(c);                   //���ַ������������
            String Key = String.valueOf(c);   //�����ת��Ϊ�ַ���

            if(!map.containsKey(Key))
                map.put(Key,new ArrayList<>());    //�ж�map����û������ַ��������û������ַ�����˵����û�г��ֺ�����ַ���һ������ĸ��λ��
            map.get(Key).add(strs[i]);                                      //Ҫ�½�һ��list��������ŵ�map��
        }

        return new ArrayList<>(map.values());
    }



    @Test
    public void test()
    {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(group(str));
    }
}
