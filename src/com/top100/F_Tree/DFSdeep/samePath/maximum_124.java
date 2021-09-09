package com.top100.F_Tree.DFSdeep.samePath;

import com.top100.F_Tree.TreeNode;

/**
 * @Author cuifua
 * @Date 2021/9/5 10:24
 * @Version 1.0
 */

//Ψһ�������ǣ�������߳�������·���Ͻڵ��value֮��.
// ��Ϊ�ڵ��value�����Ǹ���������������Һ��ӵ�ʱ��Ҫint leftSum = Math.max(0, dfs(root.left));�����������Ľ����
public class maximum_124
{
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root)
    {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root)
    {
        if (root == null)  return 0;

        int leftSum = Math.max(0, dfs(root.left)); // ������Ψһ�����������������Һ��ӵĽ���Ǹ����Ļ���������
        int rightSum = Math.max(0, dfs(root.right));

        max = Math.max(max, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;//�ݹ鷵�ص��Ǿֲ����������������
    }
}
