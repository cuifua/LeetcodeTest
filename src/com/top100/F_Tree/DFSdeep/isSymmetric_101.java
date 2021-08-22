package com.top100.F_Tree.DFSdeep;
/*
【题目】
    给定一个二叉树，检查它是否是镜像对称的。
【例题】
        1
       / \
      2   2
     / \ / \
    3  4 4  3
【思路】
    左子树的左子树和右子树的右子树相等 且 左子树的右子树和右子树的左子树相等。
 */
import com.sun.source.tree.Tree;
import com.top100.F_Tree.TreeNode;

public class isSymmetric_101
{
    public boolean isSym(TreeNode root)
    {
        return isSym1(root,root);
    }

    public boolean isSym1 (TreeNode left, TreeNode right)
    {
        if(left == null && right == null)
            return true;

        else if(left == null || right == null)
            return false;

        else if(left.val != right.val)
            return false;

        return isSym1(left.left,right.right) && isSym1(left.right,right.left);
    }
}

