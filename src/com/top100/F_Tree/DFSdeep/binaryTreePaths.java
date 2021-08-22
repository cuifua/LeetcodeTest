package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cuifua
 * @Date 2021/8/11 18:48
 * @Version 1.0
 */
/*
【题目】
    给定一个二叉树，返回所有从根节点到叶子节点的路径。
【例题】
        输入:

           1
         /   \
        2     3
         \
          5

        输出: ["1->2->5", "1->3"]
【思路】

 */
public class binaryTreePaths
{
    public List<String> binaryTreePaths(TreeNode root)
    {
        List<String> res = new ArrayList<>();

        if(root==null)
            return res;

        solve(root, "", res);
        return res;
    }

    public void solve(TreeNode root, String cur, List<String> ret)
    {
        if(root == null)
            return;

        cur += root.val;

        if(root.left == null && root.right == null)   //到了叶子节点了
            ret.add(cur);

        else
        {
            solve(root.left, cur+"->", ret);
            solve(root.right, cur+"->", ret);
        }
    }
}
