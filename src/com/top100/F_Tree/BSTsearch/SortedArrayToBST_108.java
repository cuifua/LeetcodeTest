package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

/*
����һ���������� nums ������Ԫ���Ѿ��� ���� ���У����㽫��ת��Ϊһ�� �߶�ƽ�� ������������

�߶�ƽ�� ��������һ�����㡸ÿ���ڵ���������������ĸ߶Ȳ�ľ���ֵ������ 1 ���Ķ�������
 */
public class SortedArrayToBST_108
{
    public TreeNode sort (int[] nums)
    {
        return helper(nums,0,nums.length - 1);
    }

    public TreeNode helper(int[] nums, int L , int R)
    {
        if(L > R)  return null;
        int m = L + (R-L)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = helper(nums,L,m-1);
        root.right = helper(nums,m+1,R);
        return root;
    }
}
