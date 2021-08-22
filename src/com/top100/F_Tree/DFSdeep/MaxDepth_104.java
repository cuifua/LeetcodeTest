package com.top100.F_Tree.DFSdeep;
/*
����Ŀ�� ����һ�����������ҳ��������ȡ�
        �����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
        ˵��:Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣

�����⡿ ���������� [3,9,20,null,null,15,7]��

    3
   / \
  9  20
    /  \
   15   7
��������������3
 */


import com.top100.F_Tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*�ݹ鷽��
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
//��������α�����
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

