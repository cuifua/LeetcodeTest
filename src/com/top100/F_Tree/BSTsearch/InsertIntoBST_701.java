package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

/*
����������������BST���ĸ��ڵ��Ҫ�������е�ֵ����ֵ��������������� ���ز��������������ĸ��ڵ㡣 �������� ��֤ ����ֵ��ԭʼ�����������е�����ڵ�ֵ����ͬ��
ע�⣬���ܴ��ڶ�����Ч�Ĳ��뷽ʽ��ֻҪ���ڲ�����Ա���Ϊ�������������ɡ� ����Է��� ������Ч�Ľ�� ��

����һ��ֵ����������������еĺ���λ�ã������ж��֣�
 */
public class InsertIntoBST_701
{
    public TreeNode insert(TreeNode root, int val)
    {
        if(root == null)   return new TreeNode(val);
        if(root.val < val)    root.right = insert(root.right, val);
        else                  root.left = insert(root.left, val);

        return root;
    }
}
