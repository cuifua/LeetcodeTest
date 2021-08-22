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
    public boolean isSubtree(TreeNode s, TreeNode t)
    {
        if(s == null) return false;
        return isSubtreeFromRoot(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean isSubtreeFromRoot(TreeNode s, TreeNode t)
    {
        if(s == null && t == null)
            return true;

        if(s == null || t == null)
            return false;

        if(s.val != t.val) return false;

        return isSubtreeFromRoot(s.left, t.left) && isSubtreeFromRoot(s.right, t.right);
    }
}
