package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

/*
����Ŀ��
    ����һ���������ĸ��ڵ� root����һ������ targetSum ����ö�������ڵ�ֵ֮�͵��� targetSum �� ·�� ����Ŀ��
    ·�� ����Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��
�����⡿
     ���룺root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
     �����3
     ���ͣ��͵��� 8 ��·���� 3 ������ͼ��ʾ����5��2��1����-3��11����5��3��

            10
        5        -3
     3      2         11
   3   -2      1
��˼·��
    java ˫�صݹ� ˼·����������ݹ����ÿ���ڵ㣬����ÿ���ڵ���Ϊ��ʼ��ݹ�Ѱ������������·����

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
