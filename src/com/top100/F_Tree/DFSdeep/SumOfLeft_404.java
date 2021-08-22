package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

/*
【题目】
    计算给定二叉树的所有左叶子之和。
【例题】
        3
	   / \
	  9  20
	    /  \
	   15   7

	There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
【思路】
    重点是判断是否是叶子节点。
 */
public class SumOfLeft_404
{
    //左叶子的明确定义：「如果左节点不为空，且左节点没有左右孩子，那么这个节点就是左叶子」
    //root.left != NULL && root.left.left == NULL && root.left.right == NULL        (通过父节点判断左叶子)
    public int sumLeft(TreeNode root)
    {
        if(root == null)
            return 0;

        int res = 0;
        if(root.left != null && root.left.left == null && root.left.right == null)
            res += root.left.val;

        return sumLeft(root.left) + sumLeft(root.right) + res;
    }
}
