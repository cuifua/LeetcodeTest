package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

/*
����Ŀ������������ĸ��ڵ�root ��һ����ʾĿ��͵�����targetSum ���жϸ������Ƿ���� ���ڵ㵽Ҷ�ӽڵ� ��·����
       ����·�������нڵ�ֵ��ӵ���Ŀ���targetSum ��

�����⡿ ���룺root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        �����true

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class HasPathSum_112
{
    public boolean hasSum (TreeNode root, int sum)
    {
        if(root == null)
            return false;

        if(root.left == null && root.right == null)
            return root.val==sum;

        return hasSum(root.left, sum - root.val) || hasSum(root.right,sum - root.val);
    }
}
