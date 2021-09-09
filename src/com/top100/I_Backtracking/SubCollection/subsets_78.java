package com.top100.I_Backtracking.SubCollection;

import com.top100.F_Tree.TreeNode;

import java.util.*;

/*
【题目】
    给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
    解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

【示例 1】
    输入：nums = [1,2,3]
    输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

【示例 2】
    输入：nums = [0]
    输出：[[],[0]]
 */
public class subsets_78
{
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums)
    {
        if(nums.length == 0)
        {
            res.add(new ArrayList<>());
            return res;
        }
        back(nums,0);
        return res;
    }

    public void back(int[] nums, int startIndex)
    {
        res.add(new ArrayList<>(path));
        for(int i = startIndex; i < nums.length; i++)
        {
            path.add(nums[i]);
            back(nums,i+1);
            path.removeLast();
        }
    }
}
