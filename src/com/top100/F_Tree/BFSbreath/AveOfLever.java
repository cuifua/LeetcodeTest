package com.top100.F_Tree.BFSbreath;

import com.top100.F_Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
����Ŀ��
    ����һ���ǿն�����, ����һ����ÿ��ڵ�ƽ��ֵ��ɵ����顣
�����⡿
    ���룺
        3
       / \
      9  20
        /  \
       15   7
    �����[3, 14.5, 11]
    ���ͣ�
    �� 0 ���ƽ��ֵ�� 3 ,  ��1���� 14.5 , ��2���� 11 ����˷��� [3, 14.5, 11] ��
 */
public class AveOfLever
{
    List<Double> res = new ArrayList<>();
    public List<Double> Aveoflever (TreeNode root)
    {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null)   queue.offer(root);

        int n = queue.size();
        double sum = 0.0;

        while(!queue.isEmpty())
        {
            for(int i = 0; i < n; i++)
            {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left!= null)  queue.offer(node.left);
                if(node.right!= null)  queue.offer(node.right);
            }
            res.add(sum / n);
        }
        return res;
    }
}
