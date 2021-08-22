package com.top100.F_Tree.BFSbreath;
/*
����Ŀ�� ����һ�� ��ȫ������ �ĸ��ڵ� root ����������Ľڵ������
        ��ȫ������ �Ķ������£�����ȫ�������У�������ײ�ڵ����û�����⣬����ÿ��ڵ������ﵽ���ֵ��
        ����������һ��Ľڵ㶼�����ڸò�����ߵ�����λ�á�����ײ�Ϊ�� h �㣬��ò���� 1~2h���ڵ㡣
�����⡿ ���룺root = [1,2,3,4,5,6]
        �����6
*/

/*  �ݹ�������
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

// �ݹ龫���
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

//�����������������
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


