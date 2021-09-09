package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

/*
【题目】
    给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
    路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
【例题】
     输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
     输出：3
     解释：和等于 8 的路径有 3 条，如图所示。【5、2、1】【-3、11】【5、3】

            10
        5        -3
     3      2         11
   3   -2      1
【思路】
    java 双重递归 思路：首先先序递归遍历每个节点，再以每个节点作为起始点递归寻找满足条件的路径。

 */
public class pathSumIII_437
{
    int pathnumber;
    public int pathSum(TreeNode root, int sum)
    {
        if(root == null) return 0;
        Sum(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return pathnumber;
    }


    public void Sum(TreeNode root, int sum)
    {
        if(root == null) return;
        sum-=root.val;

        if(sum == 0)
            pathnumber++;

        Sum(root.left,sum);
        Sum(root.right,sum);
    }
}
