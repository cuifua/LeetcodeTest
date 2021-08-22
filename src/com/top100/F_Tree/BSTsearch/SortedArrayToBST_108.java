package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

/*
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class SortedArrayToBST_108
{
    public TreeNode sort (int[] nums)
    {
        return helper(nums,0,nums.length - 1);
    }

    public TreeNode helper(int[] nums, int L , int R)
    {
        if(L > R)  return null;
        int m = L + (R-L)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = helper(nums,L,m-1);
        root.right = helper(nums,m+1,R);
        return root;
    }
}
