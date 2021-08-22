package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

///����һ�����������ж����Ƿ��Ǹ߶�ƽ��Ķ�������
//�����У�һ�ø߶�ƽ�����������Ϊ��
//һ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������1��
public class IsBalanced_110
{
    private boolean flag = true;
    public boolean isBalanced(TreeNode root)
    {
        maxDepth(root);
        return flag;
    }

    private int maxDepth(TreeNode root)
    {
        if(root == null) return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if(Math.abs(l-r) > 1)
            flag = false;

        return Math.max(l,r) + 1;
    }
}
