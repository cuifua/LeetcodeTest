package com.Zuo.Backtracking;

import java.util.ArrayList;

/*
【题目】
    打印一个字符串的全部排列，要求不出现重复的排列

 【思路】
    这次不用set了，因为用set其实就是将所有结果算出来以后去重，但是依旧是将所有路径全部走过一遍了
    用visit[]来表示一个字符出没出来过，在选择的时候就扼杀了即将走重复的线路，效率更高
 */
public class AllPermutations_norepeat
{
    public ArrayList<String> permutationNoRepeat(String str)
    {
        ArrayList<String> res = new ArrayList<>();
        if(str.length() == 0 || str == null)  return res;

        char[] ch = str.toCharArray();
        dfs(ch,0,res);
        return res;
    }

    /**
     * @param ch    ch[index...] ch数组后面的数字都有机会来到index下标，前面的已经固定好了，不能变了，只能是往后
     * @param index
     * @param res   结果集
     */
    public void dfs(char[] ch, int index, ArrayList<String> res)
    {
        if(index == ch.length)
            res.add(String.valueOf(ch));//把此时字符类型的数组['a','b','c']转化成“abc”

        boolean[] visit = new boolean[26];//[0 1 2 ..25] 代表着a有没有出现过，b有没有出现过....
        for(int j = index; j < ch.length; j++)//如果index没有终止，index后的数字都能来到index的位置，此时的j就是在尝试后面的数字来到index位置
        {
            if(! visit[ch[j]-'a'])
            {
                visit[ch[j]-'a'] = true;//登记一下，以后就出现过
                swap(ch,index,j);
                dfs(ch,index+1,res);
                swap(ch,index,j);//恢复现场，回溯
            }

        }
    }

    public void swap(char[] ch , int i, int j)
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
