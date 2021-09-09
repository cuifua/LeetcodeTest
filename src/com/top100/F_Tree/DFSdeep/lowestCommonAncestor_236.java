package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

/*
【题目】
    公共祖先

 */
public class lowestCommonAncestor_236
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null || root == p || root == q)  return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null)   return root;
        else if(left != null)               return left;
        else if(right != null)              return right;

        return null;
    }
}
