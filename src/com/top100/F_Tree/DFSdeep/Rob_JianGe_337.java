package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

/**
 * @Author cuifua
 * @Date 2021/8/11 14:56
 * @Version 1.0
 */

/*
【题目】
    这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
    一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
    计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
【例题】
             3
            / \
           2   3
            \   \
             3   1
        Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
【思路】
    思路：动态规划的思想。
    - 对于一个以 node 为根节点的二叉树而言，如果尝试偷取 node 节点，那么势必不能偷取其左右子节点，然后继续尝试偷取其左右子节点的左右子节点。
    - 如果不偷取该节点，那么只能尝试偷取其左右子节点。
    - 比较两种方式的结果，谁大取谁。
 */
public class Rob_JianGe_337
{
    public int rob(TreeNode root)
    {
        if(root == null)
            return 0;

        int val1 = root.val;
        if(root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) val1 += rob(root.right.left) + rob(root.right.right);

        int val2 = rob(root.left) + rob(root.right);

        return Math.max(val1, val2);
    }
}
