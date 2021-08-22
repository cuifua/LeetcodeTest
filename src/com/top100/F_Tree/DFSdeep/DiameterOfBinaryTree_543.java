package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

/*
����Ŀ��
    ����һ�ö�����������Ҫ��������ֱ�����ȡ�һ�ö�������ֱ�������������������·�������е����ֵ������·�����ܴ���Ҳ���ܲ���������㡣

�����⡿
    ����������

              1
             / \
            2   3
           / \
          4   5
    ����3, ���ĳ�����·�� [4,2,1,3] ����[5,2,1,3]��
��˼·��
    ֱ�������������߶ȼ��������߶ȡ�
    ������Ҫ��������·�������ݹ鷵��ֵ�ǵ�ǰ�����ĸ߶ȡ�
*/
public class DiameterOfBinaryTree_543
{
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root)
    {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root)
    {
        if(root == null)
            return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        max = Math.max(max,l+r);

        return Math.max(l,r) + 1;
    }
}
