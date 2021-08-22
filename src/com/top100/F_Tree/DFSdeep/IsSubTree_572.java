package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

/*
 * ����Ŀ��
 *      ���������ǿն����� s �� t������ s ���Ƿ������ t ������ͬ�ṹ�ͽڵ�ֵ��������
 *      s ��һ���������� s ��һ���ڵ������ڵ���������s Ҳ���Կ����������һ��������
 * �����⡿
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
 * ��˼·����Ҫ�������Ӹ��ڵ㿪ʼ�ݹ顣
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
