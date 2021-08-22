package com.top100.F_Tree.BFSbreath;

import com.top100.F_Tree.TreeNode;

import java.util.*;

/*
����Ŀ������һ�������������㷵���䰴 ������� �õ��Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��
�����⡿
  ��������[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
�����������������

[
  [3],
  [9,20],
  [15,7]
]
 */
public class LeverOrderBottom
{
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> Leverbottom (TreeNode root)
    {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);

        while (!queue.isEmpty())
        {
            int n = queue.size();
            List<Integer> path = new ArrayList<>();

            for(int i = 0; i < n; i++)
            {
                TreeNode node = queue.poll();
                path.add(node.val);
                if(node.left != null)    queue.offer(node.left);
                if(node.right != null)    queue.offer(node.right);
            }
            result.add(path);
        }
        Collections.reverse(result);
        return(result);
    }

}
