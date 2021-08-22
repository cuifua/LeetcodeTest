package com.top100.I_Backtracking.combination;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3_216
{
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> Combination (int n, int k)
    {
        backtracking(n,k,0,1);
        return lists;
    }

    public void backtracking (int targetSum, int k, int sum, int startIndex)  //sum指的是该路径当前的总和
    {
        if(sum > targetSum)   return;                                   //剪枝操作

        if(path.size() == k)
        {
            if(sum == targetSum)   lists.add(new ArrayList<>(path));   //这个if里的逻辑意思是，如果当前路径长度等于要求的个数，判断此刻已满的路径和是否为目标和
            return;                                                    //如果加起来是目标和，把当前路径加入到结果集中，否则直接返回
        }

        for(int i = startIndex; i <= 9-(k-path.size()) + 1 ; i++)
        {
            sum += i;
            path.add(i);
            backtracking(targetSum,k,sum,i+1);

            sum -= i;                                                  //开始回溯
            path.remove(path.size()-1);                          //开始回溯
        }
    }




    @Test
    public void test()
    {
        System.out.println(Combination(9,3));
    }
}