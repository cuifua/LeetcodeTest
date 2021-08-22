package com.top100.I_Backtracking.Arrange;
/*
【题目】给定一个 没有重复 数字的序列，返回其所有可能的全排列。
【例题】
      输入: [1,2,3]
      输出:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]

 */
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class Permute
{
    //存放结果
    List<List<Integer>> result = new ArrayList<>();
    //暂存结果
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums)
    {
        boolean[]used = new boolean[nums.length];
        backTrack(nums,used);
        return result;
    }

    private void backTrack(int[] nums, boolean[] used)
    {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) {
                continue;// path已经收录的元素，直接跳过
            }
            used[i] = true;
            path.add(nums[i]);
            backTrack(nums, used);
            path.remove(path.size() - 1);//回溯
            used[i] = false;//回溯
        }
    }






    @Test
    public void test()
    {
        int[] tst = {1,2,3};
        System.out.println(permute(tst));
    }
}


