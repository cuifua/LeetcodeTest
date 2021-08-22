package com.top100.F_Tree.BFSbreath;

import com.top100.F_Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
给定一个二叉树，在树的最后一行找到最左边的值。


        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

输出:
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

            //很重要！！！！先进右边，因为先进先出，右边出去了，最后剩的是左边最后一个！！！！
            if(root.right != null)   queue.offer(root.right);

            //很重要！！！！先进右边，因为先进先出，右边出去了，最后剩的是左边最后一个！！！！
            if(root.left != null)    queue.offer(root.left);
        }
        return root.val;
    }
}
