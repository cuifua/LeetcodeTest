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

public class CombinationSum_39
{
    List<List<Integer>> res = new ArrayList<>(); //��¼��
    List<Integer> path = new ArrayList<>();  //��¼·��

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
                dfs(candidates,i,target - candidates[i]); // ��Ϊ�����ظ�ʹ�ã����Ի���i
                path.remove(path.size()-1); //���ݣ��ָ��ֳ�
            }
        }
    }





    @Test
    public void test()
    {
        System.out.println (combinationSum(new int[]{2,3,5},8));
    }
}
