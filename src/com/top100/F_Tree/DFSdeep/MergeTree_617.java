package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

/*
����Ŀ�����������������������㽫�����е�һ�����ǵ���һ����ʱ��������������һЩ�ڵ����ص���
����Ҫ�����Ǻϲ�Ϊһ���µĶ��������ϲ��Ĺ�������������ڵ��ص�����ô�����ǵ�ֵ�����Ϊ�ڵ�ϲ������ֵ������Ϊ?NULL �Ľڵ㽫ֱ����Ϊ�¶������Ľڵ㡣

�����⡿

����:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
���:
�ϲ������:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7
ע��:�ϲ�������������ĸ��ڵ㿪ʼ��
 */
public class MergeTree_617
{
    public TreeNode merge(TreeNode t1, TreeNode t2)
    {
        if(t1 == null || t2 == null)
        {
            return t1 == null ? t2 : t1;
        }

        return dfs(t1,t2);
    }

    public TreeNode dfs(TreeNode v1, TreeNode v2)
    {
        v1.val += v2.val;
        v1.left = dfs(v1.left,v2.left);
        v1.right = dfs(v1.right,v2.right);
        return v1;
    }
}
