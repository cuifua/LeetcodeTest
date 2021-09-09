package com.top100.I_Backtracking.Other;
/*
【题目】   给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。
【例题】   输入：[4, 6, 7, 7]
          输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 */
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindSubsequences_491
{
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findsub (int[] nums)
    {
        BackTrack(nums,0);
        return result;
    }

    private void BackTrack(int[] nums,int startIndex)
    {
        if(path.size() > 1)  result.add(new ArrayList<>(path));    //注意这?不要加return，因为要取树上的所有节点
        HashSet<Integer> uset = new HashSet<>();                   //记录本层元素是否重复使?，新的?层uset都会重新定义（清空）

        for(int i = startIndex; i < nums.length; i++)
        {
            if((!path.isEmpty()) && nums[i] < path.size()-1 || !uset.add(nums[i]))   //nums[i] < path.size()-1意思是这一个数组取的数要比下一个小
                continue;


            path.add(nums[i]);
            BackTrack(nums,i+1);
            path.remove(path.size()-1);
        }
    }



    @Test
    public void test()
    {
        int[] test = {4,6,7,7};
        System.out.println(findsub(test));
    }
}

