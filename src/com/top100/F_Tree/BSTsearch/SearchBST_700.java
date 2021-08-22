package com.top100.F_Tree.BSTsearch;
/*
【题目】  给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。

【例题】
        给定二叉搜索树:

                4
               / \
              2   7
             / \
            1   3

        和值: 2
        你应该返回如下子树:

              2
             / \
            1   3

 */

/*
public class SearchBST_700
{
    public TreeNode search(TreeNode root, int val)
    {
        if(root == null || root.val == val)  return root;
        if(root.val < val)   return search(root.right, val);
        if(root.val > val)   return search(root.left, val);
        return null;
    }
}
 */

import com.top100.F_Tree.TreeNode;

//迭代法
public class SearchBST_700
{
    public TreeNode search(TreeNode root, int val)
    {
        while(root != null)
        {
            if(root.val > val)  root = root.left;
            else if(root.val < val)   root = root.right;
            else return root;
        }
        return null;
    }
}

