package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

/*��������
 */
public class lowestCommonAncestor_236
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == right) return null;      //���1�����ҽ�㶼�ǿ�
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
