package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
����Ŀ��
    ����������ĸ���� root �����㽫��չ��Ϊһ��������
    չ����ĵ�����Ӧ��ͬ��ʹ�� TreeNode ������ right ��ָ��ָ����������һ����㣬������ָ��ʼ��Ϊ null ��
    չ����ĵ�����Ӧ��������� ������� ˳����ͬ��

�����⡿
        1
     2     5     ------>   1-->2-->3-->4-->5-->6
   3   4      6

 */
public class TreeToList_114
{
    public void flatten(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        dfs(root,res);

        for(int i = 1; i < res.size(); i++)
        {
            TreeNode pre = res.get(i-1);
            TreeNode cur = res.get(i);
            pre.left = null;
            pre.right = cur;
        }

    }
    public void dfs(TreeNode root, List<TreeNode> list)
    {
        if(root != null)
        {
            list.add(root);
            dfs(root.left,list);
            dfs(root.right,list);
        }
    }
}
