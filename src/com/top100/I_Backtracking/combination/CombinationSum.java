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

public class CombinationSum
{
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> Combination (int[] nums, int target)
    {
        if(nums == null || nums.length == 0 || target < 0)   return lists;

        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        solve(nums,list,target,0);
        return lists;
    }

    private void solve(int[] nums,List<Integer> list,   int target,   int start)
    {
        if(target < 0) return;
        if(target == 0)
            lists.add(new ArrayList<>(list));

        else
        {
            for(int i = start; i < nums.length && target >= nums[i]; i++ )  //这里设置start的作用就是不让每次遍历都从0开始，否则数组会重复
            {
                list.add(nums[i]);
                solve(nums,list,target - nums[i],i);
                list.remove(list.size() - 1);
            }
        }
    }





    @Test
    public void test()
    {
        System.out.println (Combination(new int[]{2,3,5},8));
    }
}
