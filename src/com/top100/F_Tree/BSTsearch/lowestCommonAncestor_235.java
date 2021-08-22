package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

/*
二叉搜素树的公共祖先
 */
public class lowestCommonAncestor_235
{
    public TreeNode Ancestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root.val > p.val && root.val > q.val)    return Ancestor(root.left,p,q);
        if(root.val < p.val && root.val < q.val)    return Ancestor(root.right,p,q);
        else  return root;
    }
}
