package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

/*
����Ŀ��
    ����һ�����������ж����Ƿ���һ����Ч�Ķ�����������
    ����һ��������������������������
    �ڵ��������ֻ����С�ڵ�ǰ�ڵ������
    �ڵ��������ֻ�������ڵ�ǰ�ڵ������
    �������������������������Ҳ�Ƕ�����������

�����⡿
    ����:
        2
       / \
      1   3
    ���: true

    ����:
        5
       / \
      1   4
        / \
       3   6
    ���: false
    ����: ����Ϊ: [5,1,4,null,null,3,6]��
        ���ڵ��ֵΪ 5 �����������ӽڵ�ֵΪ 4 ��

 */
public class IsValidBST_98
{
    public boolean isBST(TreeNode root)
    {
        return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean valid(TreeNode node, long min, long max)
    {
        if(node == null)  return true;
        if(node.val <= min || node.val >= max)   return false;

        return valid(node.left,min,node.val) && valid(node.right , node.val, max);
    }

}
