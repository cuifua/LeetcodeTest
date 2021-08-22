package com.top100.F_Tree.BFSbreath;

import com.top100.F_Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author cuifua
 * @Date 2021/8/11 21:14
 * @Version 1.0
 */
/*============�����ٿ�
����Ŀ��
    ����һ������������дһ����������ȡ�����������ȡ����Ŀ�������в��е�����ȡ����������������������full binary tree���ṹ��ͬ����һЩ�ڵ�Ϊ�ա�
�����⡿
��˼·��
    ÿһ��Ŀ�ȱ�����Ϊ�����˵㣨�ò���������ҵķǿսڵ㣬���˵���null�ڵ�Ҳ���볤�ȣ�֮��ĳ��ȡ�
 */
public class widthOfBinaryTree
{
    public int widthOfBinaryTree(TreeNode root)
    {
        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty())
        {
            AnnotatedNode a = queue.poll();
            if (a.node != null)
            {
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                if (curDepth != a.depth)
                {
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }

    class AnnotatedNode
    {
        TreeNode node;
        int depth, pos;
        AnnotatedNode(TreeNode n, int d, int p)
        {
            node = n;
            depth = d;
            pos = p;
        }
    }

}


