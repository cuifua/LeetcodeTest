package com.top100.I_Backtracking.Arrange;
/*
����Ŀ������һ�� û���ظ� ���ֵ����У����������п��ܵ�ȫ���С�
�����⡿
      ����: [1,2,3]
      ���:
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

class Permute_46
{
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        dfs(nums,res,path);
        return res;
    }

    public void dfs(int[] nums,List<List<Integer>> res,List<Integer> path)
    {
        if(path.size() == nums.length)
        {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(path.contains(nums[i]))  continue;
            path.add(nums[i]);
            dfs(nums,res,path);
            path.remove(path.size()-1);
        }
    }






    @Test
    public void test()
    {
        int[] tst = {1,2,3};
        System.out.println(permute(tst));
    }
}


