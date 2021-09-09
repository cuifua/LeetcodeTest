package com.top100.F_Tree.DFSdeep.samePath;

import com.top100.F_Tree.TreeNode;

/**
 * @Author cuifua
 * @Date 2021/9/5 10:27
 * @Version 1.0
 */
//�������нڵ㣬��ÿ���ڵ�Ϊ���ĵ����·�������������ı߳�֮�ͣ�.
// ����ȫ��max��
// ��543Ψһ�������ǣ���������ӵı߳�leftSize��������Ӻ͵�ǰ�ڵ㲻ֵͬ�Ļ�����Ҫ��leftSize���¸�ֵ��0��
public class LongestPath_687
{
    int max = 0;
    public int longestUnivaluePath(TreeNode root)
    {
        if (root == null)   return 0;

        dfs(root);
        return max;
    }

    private int dfs(TreeNode root)
    {
        if (root.left == null && root.right == null)   return 0;


        int leftSize = root.left != null ? dfs(root.left) + 1: 0;
        int rightSize = root.right != null ? dfs(root.right) + 1: 0;

        if (leftSize > 0 && root.left.val != root.val) // Ψһ�������������������˼·�������߱߳��� �����ǰ�ڵ�����ӽڵ㲻ֵͬ���Ͱѱ߳����¸�ֵΪ0��
            leftSize = 0;

        if (rightSize > 0 && root.right.val != root.val)   // ͬ�ϡ�
            rightSize = 0;

        max = Math.max(max, leftSize + rightSize);
        return Math.max(leftSize, rightSize);
    }
}
