package com.top100.F_Tree.DFSdeep;
/*
【题目】 给定一个二叉树，找出其最大深度。
        二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
        说明:叶子节点是指没有子节点的节点。

【例题】 给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度3
 */


import com.top100.F_Tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*递归方法
public class MaxDepth
{
    public int maxDepth (TreeNode root)
    {
        if(root == null)
            return 0;
        else
        {
            int L = maxDepth(root.left);
            int R = maxDepth(root.right);
            return Math.max(L,R) + 1;
        }
    }
}
*/
//迭代（层次遍历）
public class MaxDepth_104
{
    public int maxDepth(TreeNode root)
    {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null)
            queue.offer(root);
        int depth = 0;

        while( ! queue.isEmpty())
        {
            int n = queue.size();
            depth ++;

            for (int i = 0; i < n; i++)
            {
                 TreeNode node = queue.poll();

                 if(node.left != null)    queue.offer(node.left);
                 if(node.right != null)    queue.offer(node.right);
            }
        }
        return depth;
    }
}

