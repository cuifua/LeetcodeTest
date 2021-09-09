package com.Zuo.Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
����Ŀ��
    ��ӡһ���ַ�����ȫ�������У�"abc"�������У������Ӵ�����˼��˳����Ա䣬�������˳���ܱ䣬����ab ac bc�Ϳ��ԣ�����bc  ca����
��������
    ÿ���ַ���λ�ö�������һ���жϣ���ѡ���ǲ�ѡ��
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
     * @param str    �̶�����
     * @param index  ��ʱ������λ�� Ҫ���߲�Ҫ
     * @param ans    ���յĴ�
     * @param path   ��;��·��
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

        String yes = path + String.valueOf(str[index]);//��characterת����String
        dfs(str,index+1,ans,yes);
    }
}
