package com.top100.F_Tree.BFSbreath;

import com.top100.F_Tree.TreeNode;

import java.util.*;

/*
����Ŀ��   ����һ�������������㷵���䰴 ������� �õ��Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��
�����⡿   ��������[3,9,20,null,null,15,7],

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

public class LeverOrder
{
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> leverorder (TreeNode root)
    {
        Queue<TreeNode> queue = new ArrayDeque<>();     //����ջ��ȫ�̴洢·����ֻ��result��path
        if( root != null)  queue.offer(root);

        while(!queue.isEmpty())
        {
            int n = queue.size();
            List<Integer> path = new ArrayList<>();

            for(int i = 0; i < n; i++)
            {
                TreeNode node = queue.poll();
                path.add(node.val);

                if(node.left != null)  queue.offer(node.left);
                if(node.right != null)  queue.offer(node.right);
            }
        result.add(path);
        }
    return result;
    }
}


//class LeverOrderTest
//{
//    public static void main(String[] args)
//    {
//        LeverOrder test1 = new LeverOrder();
//        System.out.println(test1.leverorder());
//    }
//}



