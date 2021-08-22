package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

/*
移除二叉树指定范围之外的元素（不仅仅是简答的移除，还需要将移除后的二叉树有序起来，不要断了）
 */
public class trimBST_669
{
    public TreeNode trim(TreeNode root, int low, int high)
    {
        if(root == null)  return root;

        if(root.val < low)
            return  trim(root.right,low,high);

        if(root.val > high)
            return trim(root.left,low,high);

        root.left = trim(root.left,low,high);
        root.right = trim(root.right, low,high);
        return root;

    }
}
