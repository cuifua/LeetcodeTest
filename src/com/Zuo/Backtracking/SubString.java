package com.Zuo.Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
【题目】
    打印一个字符串的全部子序列，"abc"的子序列，不是子串，意思是顺序可以变，但是相对顺序不能变，比如ab ac bc就可以，但是bc  ca不行
【分析】
    每个字符的位置都可以做一个判断，是选择还是不选择
 */
public class SubString
{
    public List<String> subs(String s)
    {
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();

        dfs(str,0,ans,path);
        return ans;
    }

    /**
     *
     * @param str    固定不变
     * @param index  此时来到的位置 要或者不要
     * @param ans    最终的答案
     * @param path   中途的路径
     */
    public void dfs(char[] str,int index,List<String> ans, String path)
    {
        if(index == str.length)
        {
            ans.add(path);
            return;
        }

        String no = path;
        dfs(str,index+1,ans,no);

        String yes = path + String.valueOf(str[index]);//把character转换成String
        dfs(str,index+1,ans,yes);
    }
}
