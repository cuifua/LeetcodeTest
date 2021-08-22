package com.top100.F_Tree.DFSdeep;
import com.top100.F_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
����Ŀ���г�һ����������·����·����Ҫ�������о�����ĺ�ΪĿ��ֵ
�����⡿
    root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

              10
             /  \
            5   -3
           / \    \
          3   2   11
         / \   \
        3  -2   1

        Return 3. The paths that sum to 8 are:

        1.  5 -> 3
        2.  5 -> 2 -> 1
        3. -3 -> 11

 */


/*���ݷ���
public class PathSum_II
{
    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), result);
        return result;
    }

    public void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result)
    {
        //����ڵ�Ϊ��ֱ�ӷ���
        if (root == null)
            return;

        //�ѵ�ǰ�ڵ�ֵ���뵽list��
        list.add(root.val);

        //�������Ҷ�ӽڵ㣬�Ͳ����������ˣ�ֱ��return
        if (root.left == null && root.right == null)
        {
            //�������Ҷ�ӽڵ㣬����sum����Ҷ�ӽڵ��ֵ��˵�������ҵ���һ�飬
            //Ҫ�����ŵ�result��
            if (sum == root.val)
                result.add(new ArrayList(list));

            //ע������˰�������Ľ��ֵ���Ƴ�������Ϊ��һ��ֱ��return�ˣ�
            //�����������һ�е�remove�ˣ�����������rerurn֮ǰ��ǰ�����һ������ֵ��remove����
            list.remove(list.size() - 1);
            //��Ҷ�ӽڵ�֮��ֱ�ӷ��أ���Ϊ�����¾��߲�����
            return;
        }

        //���û����Ҷ�ӽڵ㣬�ͼ������������������ӽڵ������ң�ע�⵽��һ����ʱ��sumֵҪ��ȥ��ǰ�ڵ��ֵ
        dfs(root.left, sum - root.val, list, result);
        dfs(root.right, sum - root.val, list, result);

        //����Ҫ���ݹ�ı��ʣ����ݹ����´��ݵ�ʱ��������ǻ������ߣ�
        //���ǰ����ֵʹ����֮��Ҫ�������Ƴ�������ǻ���
        list.remove(list.size() - 1);
    }
}
 */

//�ݹ鷽��
public class PathSum_II
{
    public int pathSum(TreeNode root, int sum)
    {
        if(root == null)
            return 0;

        return pathSumFromRoot(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }

    private int pathSumFromRoot(TreeNode root, int sum)//˼·����Ҫ�������Ӹ��ڵ㿪ʼ�ݹ顣
    {
        int ret = 0;
        if(root == null) return 0;

        if(sum == root.val)
            ret++;

        ret += pathSumFromRoot(root.left, sum - root.val) + pathSumFromRoot(root.right, sum - root.val);
        return ret;
    }
}
