package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

/*
【题目】
    给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree）
    使每个节点 node的新值等于原树中大于或等于node.val的值之和。
【思路】
    BST的中序遍历就是从小到大,那么反过来就是从大到小,然后累加就好了.

 */
public class ConvertBST_538
{
    int sum = 0;
    public TreeNode convert (TreeNode root)
    {
        if(root == null)   return null;

        convert(root.right);//右

        sum += root.val;
        root.val = sum;

        convert(root.left);//左

        return root;
    }
}
