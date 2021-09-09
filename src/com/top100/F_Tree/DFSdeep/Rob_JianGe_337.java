package com.top100.F_Tree.DFSdeep;
import com.top100.F_Tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

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
    /*  1��ֱ�ӵݹ飬���Ӷȸ�
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
     */

    /*  2�����˱���¼
    public int rob(TreeNode root)
    {
        Map<TreeNode,Integer> map = new HashMap<>();
        return dfs(root,map);
    }
    public int dfs(TreeNode root, Map<TreeNode,Integer> map)
    {
        if(root == null) return 0;

        if(map.containsKey(root))//�Ż��Ժ���˱���¼
            return map.get(root);

        int val1 = root.val;
        if(root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) val1 += rob(root.right.left) + rob(root.right.right);

        int val2 = rob(root.left) + rob(root.right);

        return Math.max(val1, val2);
    }
     */

    //��̬�滮��0͵1��͵����ǰ���ѡ��͵�Ļ���ѡ��ǰ�������Ҳ�͵״̬��----��ǰ��㲻͵�Ļ���ѡ������������͵�����
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
