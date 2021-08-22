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

class Permute
{
    //��Ž��
    List<List<Integer>> result = new ArrayList<>();
    //�ݴ���
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
                continue;// path�Ѿ���¼��Ԫ�أ�ֱ������
            }
            used[i] = true;
            path.add(nums[i]);
            backTrack(nums, used);
            path.remove(path.size() - 1);//����
            used[i] = false;//����
        }
    }






    @Test
    public void test()
    {
        int[] tst = {1,2,3};
        System.out.println(permute(tst));
    }
}


