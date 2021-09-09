package com.top100.I_Backtracking.SubCollection;

import com.top100.F_Tree.TreeNode;

import java.util.*;

/*
����Ŀ��
    ����һ����������nums �������е�Ԫ�� ������ͬ �����ظ��������п��ܵ��Ӽ����ݼ�����
    �⼯ ���� �����ظ����Ӽ�������԰� ����˳�� ���ؽ⼯��

��ʾ�� 1��
    ���룺nums = [1,2,3]
    �����[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

��ʾ�� 2��
    ���룺nums = [0]
    �����[[],[0]]
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
