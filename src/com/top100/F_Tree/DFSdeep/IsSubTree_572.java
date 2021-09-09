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
