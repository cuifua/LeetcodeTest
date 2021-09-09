package com.top100.F_Tree.DFSdeep.samePath;

import com.top100.F_Tree.TreeNode;

/**
 * @Author cuifua
 * @Date 2021/9/5 10:27
 * @Version 1.0
 */
//遍历所有节点，以每个节点为中心点求最长路径（左右子树的边长之和）.
// 更新全局max。
// 和543唯一的区别是，求出了左孩子的边长leftSize后，如果左孩子和当前节点不同值的话，那要把leftSize重新赋值成0。
public class LongestPath_687
{
    int max = 0;
    public int longestUnivaluePath(TreeNode root)
    {
        if (root == null)   return 0;

        dfs(root);
        return max;
    }

    private int dfs(TreeNode root)
    {
        if (root.left == null && root.right == null)   return 0;


        int leftSize = root.left != null ? dfs(root.left) + 1: 0;
        int rightSize = root.right != null ? dfs(root.right) + 1: 0;

        if (leftSize > 0 && root.left.val != root.val) // 唯一的区别在这里，按照上题思路求出了左边边长后， 如果当前节点和左孩子节点不同值，就把边长重新赋值为0。
            leftSize = 0;

        if (rightSize > 0 && root.right.val != root.val)   // 同上。
            rightSize = 0;

        max = Math.max(max, leftSize + rightSize);
        return Math.max(leftSize, rightSize);
    }
}
