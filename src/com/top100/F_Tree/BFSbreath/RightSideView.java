package com.top100.F_Tree.BFSbreath;

import com.top100.F_Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
����Ŀ������һ�ö������������Լ�վ�������Ҳ࣬���մӶ������ײ���˳�򣬷��ش��Ҳ����ܿ����Ľڵ�ֵ��
�����⡿����:[1,2,3,null,5,null,4]
���:[1, 3, 4]
����:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

 */
public class RightSideView
{
    public List<Integer> rightView(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return result;

        queue.offer(root);
        int size = queue.size();

        while (!queue.isEmpty())
        {
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (i == size - 1) result.add(node.val);
            }
        }
        return result;
    }
}
