package com.top100.J_Dynamic.Rob;

import com.top100.F_Tree.TreeNode;

/*
����Ŀ��
    ���ϴδ����һ���ֵ�֮���һȦ���ݺ�С͵�ַ�����һ���µĿ����Եĵ�����
    �������ֻ��һ����ڣ����ǳ�֮Ϊ�������� ���ˡ�����֮�⣬ÿ����������ֻ��һ��������������֮������
    һ�����֮�󣬴�����С͵��ʶ��������ط������з��ݵ�����������һ�ö��������� �������ֱ�������ķ�����ͬһ�����ϱ���٣����ݽ��Զ�������
    �����ڲ���������������£�С͵һ���ܹ���ȡ����߽�

��ʾ����
    ����: [3,2,3,null,3,null,1]

         3
        / \
       2   3
        \   \
         3   1

    ���: 7
    ����:С͵һ���ܹ���ȡ����߽�� = 3 + 3 + 1 = 7.

��ʾ����
    ����: [3,4,5,1,3,null,1]
        3
        / \
       4   5
      / \   \
     1   3   1

    ���: 9
    ����:С͵һ���ܹ���ȡ����߽��= 4 + 5 = 9.
 */
public class RobIII_337
{
    public int rob(TreeNode root)
    {
        int[] dp = dfs(root);
        return Math.max(dp[0],dp[1] );
    }

    public int[] dfs(TreeNode node)
    {
        if(node == null)  return new int[]{0,0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int[] cur = new int[2];//0��͵��1͵
        cur[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);//��͵��Max(���Ӳ�͵������͵) + Max(�Һ��Ӳ�͵���Һ���͵)
        cur[1] = node.val + left[0] + right[0];// ͵�����Ӳ�͵+ �Һ��Ӳ�͵ + ��ǰ�ڵ�͵

        return cur;
    }
}
