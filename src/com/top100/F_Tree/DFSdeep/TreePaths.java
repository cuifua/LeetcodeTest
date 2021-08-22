package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
【题目】 给定一个二叉树，返回所有从根节点到叶子节点的路径。
        说明:叶子节点是指没有子节点的节点。

【例题】
        输入:

           1
         /   \
        2     3
         \
          5

        输出: ["1->2->5", "1->3"]
 */
public class TreePaths
{
    public List<String> treepaths (TreeNode root)
    {
        List<String> res = new ArrayList<>();
        dfs(root,"",res);
        return res;

    }

    private void dfs (TreeNode root, String path, List<String> res)
    {
        //如果为空，直接返回
        if(root == null)       return;

        //如果是叶子节点，说明找到了一条路径，把它加入到res中
        if(root.left == null && root.right == null)
        {
            res.add(path + root.val);
            return;
        }

        //如果不是叶子节点，在分别遍历他的左右子节点
        else
        {
            dfs(root.left,path+root.val+"->",res);
            dfs(root.right,path+root.val+"->",res);
        }
    }
}
