package com.Zuo.Backtracking;
import java.util.ArrayList;
import java.util.List;

/*
【题目】
    [a b c]全排列---->[abc][acb][bac][bca][cb][cab]

【思路】
    第一层：把1位置的b放在0位置，把2位置的c放在0位置，就是交换
 */
public class AllPermutations
{
    public ArrayList<String> permutation(String str)
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

        for(int j = index; j < ch.length; j++)//如果index没有终止，index后的数字都能来到index的位置，此时的j就是在尝试后面的数字来到index位置
        {
            swap(ch,index,j);
            dfs(ch,index+1,res);
            swap(ch,index,j);//恢复现场，回溯
        }
    }

    public void swap(char[] ch , int i, int j)
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
