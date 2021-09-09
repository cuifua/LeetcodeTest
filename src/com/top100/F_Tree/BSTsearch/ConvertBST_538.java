package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

/*
����Ŀ��
    �������� ���� ���ĸ��ڵ㣬�����Ľڵ�ֵ������ͬ�����㽫��ת��Ϊ�ۼ�����Greater Sum Tree��
    ʹÿ���ڵ� node����ֵ����ԭ���д��ڻ����node.val��ֵ֮�͡�
��˼·��
    BST������������Ǵ�С����,��ô���������ǴӴ�С,Ȼ���ۼӾͺ���.

 */
public class ConvertBST_538
{
    int sum = 0;
    public TreeNode convert (TreeNode root)
    {
        if(root == null)   return null;

        convert(root.right);//��

        sum += root.val;
        root.val = sum;

        convert(root.left);//��

        return root;
    }
}
