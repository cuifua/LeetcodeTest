package com.top100.F_Tree.DFSdeep.samePath;

import com.top100.F_Tree.TreeNode;

/**
 * @Author cuifua
 * @Date 2021/9/5 10:24
 * @Version 1.0
 */

//唯一的区别是：不是求边长，而是路径上节点的value之和.
// 因为节点的value可能是负数，因此求左孩子右孩子的时候要int leftSum = Math.max(0, dfs(root.left));舍弃掉负数的结果。
public class maximum_124
{
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root)
    {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root)
    {
        if (root == null)  return 0;

        int leftSum = Math.max(0, dfs(root.left)); // 和上题唯一的区别在这里，如果左右孩子的结果是负数的话就舍弃。
        int rightSum = Math.max(0, dfs(root.right));

        max = Math.max(max, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;//递归返回的是局部的左右子树里最长的
    }
}
