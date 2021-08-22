package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

/**
 * @Author cuifua
 * @Date 2021/8/11 14:56
 * @Version 1.0
 */

/*
����Ŀ��
    �������ֻ��һ����ڣ����ǳ�֮Ϊ�������� ���ˡ�����֮�⣬ÿ����������ֻ��һ��������������֮������
    һ�����֮�󣬴�����С͵��ʶ��������ط������з��ݵ�����������һ�ö��������� �������ֱ�������ķ�����ͬһ�����ϱ���٣����ݽ��Զ�������
    �����ڲ���������������£�С͵һ���ܹ���ȡ����߽�
�����⡿
             3
            / \
           2   3
            \   \
             3   1
        Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
��˼·��
    ˼·����̬�滮��˼�롣
    - ����һ���� node Ϊ���ڵ�Ķ��������ԣ��������͵ȡ node �ڵ㣬��ô�Ʊز���͵ȡ�������ӽڵ㣬Ȼ���������͵ȡ�������ӽڵ�������ӽڵ㡣
    - �����͵ȡ�ýڵ㣬��ôֻ�ܳ���͵ȡ�������ӽڵ㡣
    - �Ƚ����ַ�ʽ�Ľ����˭��ȡ˭��
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
