package com.top100.I_Backtracking.combination;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author cuifua
 * @Date 2021/8/21 21:38
 * @Version 1.0
 */

/*
����Ŀ��
    ������������ n �� k�����ط�Χ [1, n] �����п��ܵ� k ��������ϡ�����԰� �κ�˳�� ���ش𰸡�
�����⡿
    ���룺n = 4, k = 2
    �����
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
 */
public class combine_77
{
    public List<List<Integer>> combine(int n, int k)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k)
            return res;

        // �� 1 ��ʼ����Ŀ���趨
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);

        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res)
    {
        // �ݹ���ֹ�����ǣ�path �ĳ��ȵ��� k
        if (path.size() == k)
        {
            res.add(new ArrayList<>(path));
            return;
        }

        // �������ܵ��������
        for (int i = begin; i <= n; i++)
        {
            // ��·�����������һ����
            path.addLast(i);

            // ��һ�����������õ��������Ҫ�� 1����Ϊ������ﲻ��������ظ���Ԫ��
            dfs(n, k, i + 1, path, res);

            // �ص�������������ȱ����л�ͷ�Ĺ��̣���˵ݹ�֮ǰ����ʲô���ݹ�֮����Ҫ����ͬ�������������
            path.removeLast();
        }
    }
}
