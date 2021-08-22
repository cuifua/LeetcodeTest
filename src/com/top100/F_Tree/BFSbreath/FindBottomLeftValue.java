package com.top100.F_Tree.BFSbreath;

import com.top100.F_Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
����һ�������������������һ���ҵ�����ߵ�ֵ��


        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

���:
7

 */
public class FindBottomLeftValue
{
    public int find (TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)
            queue.offer(root);

        while(! queue.isEmpty())
        {
            root = queue.poll();

            //����Ҫ���������Ƚ��ұߣ���Ϊ�Ƚ��ȳ����ұ߳�ȥ�ˣ����ʣ����������һ����������
            if(root.right != null)   queue.offer(root.right);

            //����Ҫ���������Ƚ��ұߣ���Ϊ�Ƚ��ȳ����ұ߳�ȥ�ˣ����ʣ����������һ����������
            if(root.left != null)    queue.offer(root.left);
        }
        return root.val;
    }
}
