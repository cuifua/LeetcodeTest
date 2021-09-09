package com.Zuo.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
【题目】
    打印一个字符串的全部子序列，要求不要出现重复字面值的子序列
【思路】
     加个Set去重就好了
 */
public class SubString_norepeat
{
    public List<String> subNoRepeace(String s)
    {
        char[] str = s.toCharArray();
        HashSet<String> set = new HashSet<>();
        String path = "";
        dfs(str,0,set,path);

        List<String> ans = new ArrayList<>();
        for(String cur : set)
            ans.add(cur);

        return ans;
    }

    public void dfs(char[] str, int index, HashSet<String> set, String path)
    {
        if(index == str.length)
        {
            set.add(path);
            return;
        }

        String no = path;
        dfs(str,index+1,set,no);

        String yes = path + String.valueOf(str[index]);//把character转换成String
        dfs(str,index+1,set,yes);
    }
}
