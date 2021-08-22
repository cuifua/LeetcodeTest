package com.top100.F_Tree.BFSbreath;

import com.top100.F_Tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author cuifua
 * @Date 2021/8/11 20:16
 * @Version 1.0
 */
/*
【题目】
    请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintZHI
{
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();

        if(pRoot == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;

        while(!queue.isEmpty())
        {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();

            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(reverse)
                Collections.reverse(list);

            result.add(list);
            reverse = !reverse;//BFS，使用队列，用一个标志位来决定是否需要翻转。
        }
        return result;
    }
}
