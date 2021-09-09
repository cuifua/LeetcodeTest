package com.top100.I_Backtracking.Cut;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
【题目】给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

【例题】输入：s = "aab"
      输出：[["a","a","b"],["aa","b"]]
 */
public class Partition_131
{
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partiton (String s)
    {
        backtrack(s,0,
                new ArrayList<>());
        return result;
    }

    private void backtrack(String s,int startIndex,List<String> path)
    {
        if(startIndex >= s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i < s.length(); i++)
        {
            if(isPalindrome(s,startIndex,i))
            {
                String str = s.substring(startIndex,i + 1);
                path.add(str);
            }
            else  continue;;

            backtrack(s,i + 1,path);
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s,int start, int end)
    {
        for(int i = start, j = end; i < j; i++,j--)
        {
            if(s.charAt(i) != s.charAt(j))  return false;
        }
        return true;
    }









    @Test
    public void test()
    {
        System.out.println(partiton("aab"));
    }
}

