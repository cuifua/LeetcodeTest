package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

/*
【题目】给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，
       这条路径上所有节点值相加等于目标和targetSum 。

【例题】 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        输出：true

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class HasPathSum_112
{
    public boolean hasSum (TreeNode root, int sum)
    {
        if(root == null)
            return false;

        if(root.left == null && root.right == null)
            return root.val==sum;

        return hasSum(root.left, sum - root.val) || hasSum(root.right,sum - root.val);
    }
}
