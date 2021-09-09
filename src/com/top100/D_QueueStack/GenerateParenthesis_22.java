package com.top100.D_QueueStack;
/*
����Ŀ��
    ���� n�����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
�����⡿
    ���룺n = 3
    �����["((()))","(()())","(())()","()(())","()()()"]
*/

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
class GenerateParenthesis_22
{
    public List<String> generate(int n)
    {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        dfs(n, "", res, 0, 0);
        return res;
    }

    private void dfs(int n, String path, List<String> res, int open, int close)
    {
        if (open > n || close > open) return;

        if (path.length() == 2 * n)
        {
            res.add(path);
            return;
        }

        dfs(n, path + "(", res, open + 1, close);
        dfs(n, path + ")", res, open, close + 1);
    }

    @Test
    public void test()
    {
        System.out.println(new GenerateParenthesis_22().generate(2));
    }
}




