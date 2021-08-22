package com.top100.F_Tree.BFSbreath;
/*
【题目】 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
        完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
        并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~2h个节点。
【例题】 输入：root = [1,2,3,4,5,6]
        输出：6
*/

/*  递归完整版
public class CountNodes
{
    public int count (TreeNode root)
    {
       return getNum(root);
    }

    public int getNum(TreeNode node)
    {
        if(node == null)  return 0;
        int L = getNum(node.left);
        int R = getNum(node.right);
        int num = 1 + L + R;
        return num;
    }
}

// 递归精简版
public class CountNodes
{
    public int count (TreeNode root)
    {
        if(root == null)  return 0;
        return 1 + count(root.left) + count(root.right);
    }
}

 */

import com.top100.F_Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

//迭代法（层序遍历）
public class CountNodes_222
{
    public int count (TreeNode root)
    {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null)  return 0;
        queue.offer(root);

        int count = 0;
        int n = queue.size();
        while(! queue.isEmpty())
        {
            for (int i = 0; i < n; i++)
            {
                 TreeNode node = queue.poll();
                 count ++;

                 if(node.left != null)   queue.offer(node.left);
                 if(node.right != null)  queue.offer(node.right);
            }

        }
        return count;
    }
}


