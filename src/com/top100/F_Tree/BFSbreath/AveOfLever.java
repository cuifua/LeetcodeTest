package com.top100.F_Tree.BFSbreath;

import com.top100.F_Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
【题目】
    给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
【例题】
    输入：
        3
       / \
      9  20
        /  \
       15   7
    输出：[3, 14.5, 11]
    解释：
    第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
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
