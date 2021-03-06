package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

/*
【题目】 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
        一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。
说明： 要求算法时间复杂度为O(h)，h 为树的高度。

【例题】

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。

一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。

    5
   / \
  4   6
 /     \
2       7

另一个正确答案是 [5,2,6,null,4,null,7]。

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
