package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

public class baseDFS
{
    public static void treeDFS(TreeNode root)
    {
        //��ǰ�ڵ�Ϊ��ֱ�ӷ���
        if (root == null) return;

        //��ӡ��ǰ�ڵ��ֵ
        System.out.println(root.val);

        //Ȼ��ݹ���������ӽڵ�
        treeDFS(root.left);
        treeDFS(root.right);
    }
}
