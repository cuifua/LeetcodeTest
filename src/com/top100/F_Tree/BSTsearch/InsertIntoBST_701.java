package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

/*
给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。

给定一个值，插入二叉搜索树中的合适位置（可以有多种）
 */
public class InsertIntoBST_701
{
    public TreeNode insert(TreeNode root, int val)
    {
        if(root == null)   return new TreeNode(val);
        if(root.val < val)    root.right = insert(root.right, val);
        else                  root.left = insert(root.left, val);

        return root;
    }
}
