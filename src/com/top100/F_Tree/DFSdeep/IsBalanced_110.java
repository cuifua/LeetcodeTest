package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

///给定一个二叉树，判断它是否是高度平衡的二叉树。
//本题中，一棵高度平衡二叉树定义为：
//一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
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
