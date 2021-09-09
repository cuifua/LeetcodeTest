package com.Company.xiapi;

import java.util.ArrayList;

/**
 * @Author cuifua
 * @Date 2021/9/7 12:22
 * @Version 1.0
 */
public class StringCombination_xp
{
    ArrayList<String> ans = new ArrayList<>();

    public String[] permutation(String s)
    {
        //判断一些特殊情况 否则只有90
        if(s==null||s.length()==0)
            return new String[0];

        if(s.length()==1)
            return new String[]{s};


        char[] ch=s.toCharArray();
        dfs(ch,0,"");
        return ans.toArray(new String[ans.size()]);
    }

    private void dfs(char[] ch, int cur,String s)
    {
        if(cur==ch.length)
        {
            ans.add(s);
            return;
        }
        for(int i=cur;i<ch.length;i++)
        {
            swap(ch,cur,i);
            dfs(ch,cur+1,s+ch[cur]);
            swap(ch,cur,i);
        }
    }

    private void swap(char[] ch,int i,int j)
    {
        char tmp=ch[i];
        ch[i]=ch[j];
        ch[j]=tmp;
    }
}
