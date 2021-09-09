package com.top100.I_Backtracking.Other;
/*
����Ŀ��   ����һ����������, ����������ҵ����и�����ĵ��������У����������еĳ��������� 2 ��
�����⡿   ���룺[4, 6, 7, 7]
          �����[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
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
        if(path.size() > 1)  result.add(new ArrayList<>(path));    //ע����?��Ҫ��return����ΪҪȡ���ϵ����нڵ�
        HashSet<Integer> uset = new HashSet<>();                   //��¼����Ԫ���Ƿ��ظ�ʹ?���µ�?��uset�������¶��壨��գ�

        for(int i = startIndex; i < nums.length; i++)
        {
            if((!path.isEmpty()) && nums[i] < path.size()-1 || !uset.add(nums[i]))   //nums[i] < path.size()-1��˼����һ������ȡ����Ҫ����һ��С
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

