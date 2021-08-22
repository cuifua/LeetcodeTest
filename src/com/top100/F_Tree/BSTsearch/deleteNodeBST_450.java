package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

/*
����Ŀ�� ����һ�������������ĸ��ڵ� root ��һ��ֵ key��ɾ�������������е�key��Ӧ�Ľڵ㣬����֤���������������ʲ��䡣���ض������������п��ܱ����£��ĸ��ڵ�����á�
        һ����˵��ɾ���ڵ�ɷ�Ϊ�������裺

�����ҵ���Ҫɾ���Ľڵ㣻
����ҵ��ˣ�ɾ������
˵���� Ҫ���㷨ʱ�临�Ӷ�ΪO(h)��h Ϊ���ĸ߶ȡ�

�����⡿

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

������Ҫɾ���Ľڵ�ֵ�� 3���������������ҵ� 3 ����ڵ㣬Ȼ��ɾ������

һ����ȷ�Ĵ��� [5,4,6,2,null,null,7], ����ͼ��ʾ��

    5
   / \
  4   6
 /     \
2       7

��һ����ȷ���� [5,2,6,null,4,null,7]��

    5
   / \
  2   6
   \   \
    4   7
 */
public class deleteNodeBST_450
{
   public TreeNode delete(TreeNode root, int key)
   {
       if(root == null)         return null;
       if(key < root.val)       root.left = delete(root.left,key);
       else if(key > root.val)  root.right = delete(root.right, key);

       else
       {
           if(root.left == null)  return root.right;
           else if(root.right == null) return root.left;
           else
           {
               TreeNode node = root.right;
               while(node.left != null)
               {
                   node = node.left;
               }
               node.left = root.left;
               return root.right;
           }

       }
       return  root;
   }
}
