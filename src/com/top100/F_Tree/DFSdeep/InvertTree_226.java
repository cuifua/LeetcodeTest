package com.top100.F_Tree.DFSdeep;
//¡¾¾µÏñ·­×ª¶þ²æÊ÷¡¿

import com.top100.F_Tree.TreeNode;

public class InvertTree_226
{
    public TreeNode invert(TreeNode root)
    {
        if(root == null) return null;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        root.left = invert(root.left);
        root.right = invert(root.right);

        return root;
    }
}
