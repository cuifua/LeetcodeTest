package com.top100.C_String.DUIbI;
/*
【题目】
    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
【例题】
         输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
         输出:
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
            char[] c = strs[i].toCharArray(); //取出字符串，然后把它转化为字符数组
            Arrays.sort(c);                   //对字符数组进行排序
            String Key = String.valueOf(c);   //排序后转化为字符串

            if(!map.containsKey(Key))
                map.put(Key,new ArrayList<>());    //判断map中有没有这个字符串，如果没有这个字符串，说明还没有出现和这个字符串一样的字母异位词
            map.get(Key).add(strs[i]);                                      //要新建一个list，把它存放到map中
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
