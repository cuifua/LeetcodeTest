package com.top100.F_Tree.BFSbreath;

import com.top100.F_Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author cuifua
 * @Date 2021/8/11 20:06
 * @Version 1.0
 */
/*
【题目】
    从上往下打印出二叉树的每个节点，同层节点从左至右打印。
【例题】

【思路】
    BFS使用队列进行遍历。
 */
public class PrintFromTopToBottom
{
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            result.add(node.val);

            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }
        return result;
    }
}
