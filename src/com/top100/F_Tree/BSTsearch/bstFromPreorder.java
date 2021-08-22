package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

/*
���������ǰ����� preorder ��ƥ��Ķ�����������binary search tree���ĸ���㡣
 */
public class bstFromPreorder
{
    public TreeNode bst(int[] preorder)
    {
        // ���ȶ�����˵���Ѹ��ڵ���Ϊ��һ��Ԫ��
        TreeNode root = new TreeNode(preorder[0]);

        // Ȼ�󰤸��Ӹ��ڵ㿪ʼ����
        for (int i = 1; i < preorder.length; ++i)
            insert(preorder[i], root);
        return root;
    }

    private void insert(int val, TreeNode root)
    {
        if (val < root.val)
        {
            // ��� val �ȵ�ǰ�������ڵ���ֵС����ô�Ͳ���ø��ڵ��������
            // �����ڴ�֮ǰ��Ҫ�ȿ������ڵ���������ǲ��ǿյģ�����ǿյľ�ֱ�ӷŽ������ˣ�������ǵĻ�������Ҫ�ݹ����
            if (root.left == null)     root.left = new TreeNode(val);
            else insert(val, root.left);
        }

        else
            {
            // ˼·ͬ�ϣ�ֻ�����ǱȽ��������ڵ���
            if (root.right == null) root.right = new TreeNode(val);
            else insert(val, root.right);
            }

    }
}
