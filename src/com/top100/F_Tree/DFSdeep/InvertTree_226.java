package com.top100.F_Tree.DFSdeep;
//������ת��������

import com.top100.F_Tree.TreeNode;

public class InvertTree_226
{
    public TreeNode invert(TreeNode root)
    {
        if(root == null) return null;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invert(root.left);
        invert(root.right);

        return root;
    }
}
