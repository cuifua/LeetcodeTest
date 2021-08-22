package com.top100.I_Backtracking.combination;
/*
����һ�����ظ�Ԫ�ص�����candidates��һ��Ŀ����target���ҳ�candidates�����п���ʹ���ֺ�Ϊtarget����ϡ�
candidates�е����ֿ����������ظ���ѡȡ��
˵����
�������֣�����target��������������
�⼯���ܰ����ظ�����ϡ�
��������
      ���룺candidates = [2,3,6,7], target = 7,
      ����⼯Ϊ��
     [
      [7],
      [2,2,3]
     ]

     ���룺candidates = [2,3,5], target = 8,
     ����⼯Ϊ��
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
            for(int i = start; i < nums.length && target >= nums[i]; i++ )  //��������start�����þ��ǲ���ÿ�α�������0��ʼ������������ظ�
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
