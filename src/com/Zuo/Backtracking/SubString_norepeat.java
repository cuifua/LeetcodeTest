package com.Zuo.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
����Ŀ��
    ��ӡһ���ַ�����ȫ�������У�Ҫ��Ҫ�����ظ�����ֵ��������
��˼·��
     �Ӹ�Setȥ�ؾͺ���
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

        String yes = path + String.valueOf(str[index]);//��characterת����String
        dfs(str,index+1,set,yes);
    }
}
