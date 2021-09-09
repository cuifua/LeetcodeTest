package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

import java.util.Arrays;

/*
【题目】
    给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点

【例题】
    Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    Output: [3,9,20,null,null,15,7]
 */
public class BuildTree_105
{
    public TreeNode buildTree(int[] preorder, int[] inorder)//
    {
        if(preorder.length == 0 || inorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 0; i < inorder.length; i++)
        {
            if(inorder[i] == preorder[0])
            {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1,i+1),Arrays.copyOfRange(inorder, 0,i));
                root.right = buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
                break;
            }
        }
        return root;
    }
}
