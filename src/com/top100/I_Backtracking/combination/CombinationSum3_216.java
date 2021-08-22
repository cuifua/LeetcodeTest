package com.top100.I_Backtracking.combination;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3_216
{
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> Combination (int n, int k)
    {
        backtracking(n,k,0,1);
        return lists;
    }

    public void backtracking (int targetSum, int k, int sum, int startIndex)  //sumָ���Ǹ�·����ǰ���ܺ�
    {
        if(sum > targetSum)   return;                                   //��֦����

        if(path.size() == k)
        {
            if(sum == targetSum)   lists.add(new ArrayList<>(path));   //���if����߼���˼�ǣ������ǰ·�����ȵ���Ҫ��ĸ������жϴ˿�������·�����Ƿ�ΪĿ���
            return;                                                    //�����������Ŀ��ͣ��ѵ�ǰ·�����뵽������У�����ֱ�ӷ���
        }

        for(int i = startIndex; i <= 9-(k-path.size()) + 1 ; i++)
        {
            sum += i;
            path.add(i);
            backtracking(targetSum,k,sum,i+1);

            sum -= i;                                                  //��ʼ����
            path.remove(path.size()-1);                          //��ʼ����
        }
    }




    @Test
    public void test()
    {
        System.out.println(Combination(9,3));
    }
}