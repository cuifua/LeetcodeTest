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
����Ŀ��
    �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
�����⡿

��˼·��
    BFSʹ�ö��н��б�����
 */
public class PrintFromTopToBottom
{
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null)  return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            result.add(node.val);

            if(node.left != null)   q.offer(node.left);
            if(node.right != null)  q.offer(node.right);
        }
        return result;
    }
}
