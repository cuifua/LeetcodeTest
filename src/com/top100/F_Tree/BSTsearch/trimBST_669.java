package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

/*
�Ƴ�������ָ����Χ֮���Ԫ�أ��������Ǽ����Ƴ�������Ҫ���Ƴ���Ķ�����������������Ҫ���ˣ�
 */
public class trimBST_669
{
    public TreeNode trim(TreeNode root, int low, int high)
    {
        if(root == null)  return root;

        if(root.val < low)
            return  trim(root.right,low,high);

        if(root.val > high)
            return trim(root.left,low,high);

        root.left = trim(root.left,low,high);
        root.right = trim(root.right, low,high);
        return root;

    }
}
