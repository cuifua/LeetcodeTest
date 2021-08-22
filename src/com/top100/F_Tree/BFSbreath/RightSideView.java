package com.top100.F_Tree.BFSbreath;

import com.top100.F_Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
【题目】给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
【例题】输入:[1,2,3,null,5,null,4]
输出:[1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

 */
public class RightSideView
{
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightView(TreeNode root)
    {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return result;

        queue.offer(root);
        int n = queue.size();

        while (!queue.isEmpty())
        {
            for (int i = 0; i < n; i++)
            {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (i == n - 1) result.add(node.val);
            }
        }
        return result;
    }
}
