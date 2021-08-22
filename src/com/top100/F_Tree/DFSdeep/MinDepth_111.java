package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
/*
【题目】
    给定一个二叉树，找出其最小深度。
    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
【例题】
【思路】
    叶子节点返回1，没有左节点则返回右节点的高度+1，没有右节点则返回左节点高度+1，都有返回最小高度＋1，与**1.树的高度**对比。
 */
/*  递归方法
public class MinDepth
{
   public int minDepth(TreeNode root)
   {
        if(root == null)
            return 0;

        int l = minDepth(root.left);
        int r = minDepth(root.right);

        if(l == 0 || r == 0) return l + r + 1;//三种情况均能满足（叶子j、只有左、只有右）
        return Math.min(l, r) + 1;
    }
}
*/
//迭代（层次遍历）
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
