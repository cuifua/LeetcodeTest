package com.top100.I_Backtracking.combination;
/*
给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
candidates中的数字可以无限制重复被选取。
说明：
所有数字（包括target）都是正整数。
解集不能包含重复的组合。
【举例】
      输入：candidates = [2,3,6,7], target = 7,
      所求解集为：
     [
      [7],
      [2,2,3]
     ]

     输入：candidates = [2,3,5], target = 8,
     所求解集为：
    [
     [2,2,2,2],
     [2,3,3],
     [3,5]
   ]
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39
{
    List<List<Integer>> res = new ArrayList<>(); //记录答案
    List<Integer> path = new ArrayList<>();  //记录路径

    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        dfs(candidates,0, target);
        return res;
    }

    public void dfs(int[] candidates, int start, int target)
    {
        if(target < 0) return ;

        if(target == 0)
        {
            res.add(new ArrayList(path));
            return ;
        }

        for(int i = start; i < candidates.length; i++){
            if(candidates[i] <= target)
            {
                path.add(candidates[i]);
                dfs(candidates,i,target - candidates[i]); // 因为可以重复使用，所以还是i
                path.remove(path.size()-1); //回溯，恢复现场
            }
        }
    }





    @Test
    public void test()
    {
        System.out.println (combinationSum(new int[]{2,3,5},8));
    }
}
