package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

/*
 * 【题目】
 *      给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 *      s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * 【例题】
               Given tree s:
         *      3
         *     / \
         *    4   5
         *   / \
         *  1   2
         *
         * Given tree t:
         *    4
         *   / \
         *  1   2
         *
         * Return true, because t has the same structure and node values with a subtree of s.
         *
         *
         * Given tree s:
         *
         *      3
         *     / \
         *    4   5
         *   / \
         *  1   2
         *     /
         *    0
         *
         * Given tree t:
         *    4
         *   / \
         *  1   2
         *
         * Return false.
 * 【思路】需要另建方法从根节点开始递归。
 */
public class IsSubTree_572
{
    public boolean isSubtree(TreeNode root1, TreeNode root2)
    {
        if(root1 == null) return false;
        return isSubtreeFromRoot(root1,root2) || isSubtree(root1.left,root2) || isSubtree(root1.right,root2);
    }

    public boolean isSubtreeFromRoot(TreeNode root1, TreeNode root2)
    {
        if(root1 == null && root2 == null)
            return true;

        if(root1 == null || root2 == null)
            return false;

        if(root1.val != root2.val) return false;

        return isSubtreeFromRoot(root1.left, root2.left) && isSubtreeFromRoot(root1.right, root2.right);
    }
}
