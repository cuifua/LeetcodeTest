package com.top100.F_Tree.BSTsearch;
/*
����Ŀ��  ����������������BST���ĸ��ڵ��һ��ֵ�� ����Ҫ��BST���ҵ��ڵ�ֵ���ڸ���ֵ�Ľڵ㡣 �����Ըýڵ�Ϊ���������� ����ڵ㲻���ڣ��򷵻� NULL��

�����⡿
        ��������������:

                4
               / \
              2   7
             / \
            1   3

        ��ֵ: 2
        ��Ӧ�÷�����������:

              2
             / \
            1   3

 */

/*
public class SearchBST_700
{
    public TreeNode search(TreeNode root, int val)
    {
        if(root == null || root.val == val)  return root;
        if(root.val < val)   return search(root.right, val);
        if(root.val > val)   return search(root.left, val);
        return null;
    }
}
 */

import com.top100.F_Tree.TreeNode;

//������
public class SearchBST_700
{
    public TreeNode search(TreeNode root, int val)
    {
        while(root != null)
        {
            if(root.val > val)  root = root.left;
            else if(root.val < val)   root = root.right;
            else return root;
        }
        return null;
    }
}

