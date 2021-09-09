package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
【题目】
    给你二叉树的根结点 root ，请你将它展开为一个单链表：
    展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
    展开后的单链表应该与二叉树 先序遍历 顺序相同。

【例题】
        1
     2     5     ------>   1-->2-->3-->4-->5-->6
   3   4      6

 */
public class TreeToList_114
{
    public void flatten(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        dfs(root,res);

        for(int i = 1; i < res.size(); i++)
        {
            TreeNode pre = res.get(i-1);
            TreeNode cur = res.get(i);
            pre.left = null;
            pre.right = cur;
        }

    }
    public void dfs(TreeNode root, List<TreeNode> list)
    {
        if(root != null)
        {
            list.add(root);
            dfs(root.left,list);
            dfs(root.right,list);
        }
    }
}
