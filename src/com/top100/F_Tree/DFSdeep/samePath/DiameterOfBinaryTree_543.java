package com.top100.F_Tree.DFSdeep.samePath;

import com.top100.F_Tree.TreeNode;

/*
【题目】
    给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

【例题】
    给定二叉树

              1
             / \
            2   3
           / \
          4   5
    返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
【思路】
    直径等于左子树高度加右子树高度。
    这里需要的输出是最长路径，而递归返回值是当前子树的高度。
*/
public class DiameterOfBinaryTree_543
{
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root)
    {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root)
    {
        if(root == null)
            return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        max = Math.max(max,l+r);//【这里需要的输出是最长路径，而递归返回值是当前子树的高度。】

        return Math.max(l,r) + 1;//【这里需要的输出是最长路径，而递归返回值是当前子树的高度。】
    }
}
