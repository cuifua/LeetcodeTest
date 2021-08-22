package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
/*
����Ŀ��
    ����һ�����������ҳ�����С��ȡ�
    ��С����ǴӸ��ڵ㵽���Ҷ�ӽڵ�����·���ϵĽڵ�������
�����⡿
��˼·��
    Ҷ�ӽڵ㷵��1��û����ڵ��򷵻��ҽڵ�ĸ߶�+1��û���ҽڵ��򷵻���ڵ�߶�+1�����з�����С�߶ȣ�1����**1.���ĸ߶�**�Աȡ�
 */
/*  �ݹ鷽��
public class MinDepth
{
   public int minDepth(TreeNode root)
   {
        if(root == null)
            return 0;

        int l = minDepth(root.left);
        int r = minDepth(root.right);

        if(l == 0 || r == 0) return l + r + 1;//��������������㣨Ҷ��j��ֻ����ֻ���ң�
        return Math.min(l, r) + 1;
    }
}
*/
//��������α�����
public class MinDepth_111
{
    public int minDepth (TreeNode root)
    {
        if(root == null)  return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int depth = 0;
        while(! queue.isEmpty())
        {
            int n = queue.size();
            depth ++;
            int flag = 0;

            for (int i = 0; i < n; i++)
            {
                TreeNode node = queue.poll();

                if(node.left != null)  queue.offer(node.left);
                if(node.right != null)  queue.offer(node.right);
                if(node.left == null && node.right == null)
                {
                    flag = 1;
                    break;
                }

            }
            if(flag == 1)  break;
        }
        return depth;
    }
}
