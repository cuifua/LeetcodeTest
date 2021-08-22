package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。
假设一个二叉搜索树具有如下特征：
节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
输入:
    2
   / \
  1   3
输出: true

输入:
    5
   / \
  1   4
    / \
   3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
    根节点的值为 5 ，但是其右子节点值为 4 。

 */
public class IsValidBST_98
{
    public boolean isBST(TreeNode root)
    {
        return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean valid(TreeNode node, long min, long max)
    {
        if(node == null)  return true;
        if(node.val <= min || node.val >= max)   return false;

        return valid(node.left,min,node.val) && valid(node.right , node.val, max);
    }

}
