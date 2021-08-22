package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

/*
����Ŀ��
    ���������������������Ҷ��֮�͡�
�����⡿
        3
	   / \
	  9  20
	    /  \
	   15   7

	There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
��˼·��
    �ص����ж��Ƿ���Ҷ�ӽڵ㡣
 */
public class SumOfLeft_404
{
    //��Ҷ�ӵ���ȷ���壺�������ڵ㲻Ϊ�գ�����ڵ�û�����Һ��ӣ���ô����ڵ������Ҷ�ӡ�
    //root.left != NULL && root.left.left == NULL && root.left.right == NULL        (ͨ�����ڵ��ж���Ҷ��)
    public int sumLeft(TreeNode root)
    {
        if(root == null)
            return 0;

        int res = 0;
        if(root.left != null && root.left.left == null && root.left.right == null)
            res += root.left.val;

        return sumLeft(root.left) + sumLeft(root.right) + res;
    }
}
