package com.top100.F_Tree.DFSdeep;
import com.top100.F_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
【题目】列出一棵树的所有路径，路径的要求是所有经过点的和为目标值
【例题】
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


/*回溯方法
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
        //如果节点为空直接返回
        if (root == null)
            return;

        //把当前节点值加入到list中
        list.add(root.val);

        //如果到达叶子节点，就不能往下走了，直接return
        if (root.left == null && root.right == null)
        {
            //如果到达叶子节点，并且sum等于叶子节点的值，说明我们找到了一组，
            //要把它放到result中
            if (sum == root.val)
                result.add(new ArrayList(list));

            //注意别忘了把最后加入的结点值给移除掉，因为下一步直接return了，
            //不会再走最后一行的remove了，所以这里在rerurn之前提前把最后一个结点的值给remove掉。
            list.remove(list.size() - 1);
            //到叶子节点之后直接返回，因为在往下就走不动了
            return;
        }

        //如果没到达叶子节点，就继续从他的左右两个子节点往下找，注意到下一步的时候，sum值要减去当前节点的值
        dfs(root.left, sum - root.val, list, result);
        dfs(root.right, sum - root.val, list, result);

        //我们要理解递归的本质，当递归往下传递的时候他最后还是会往回走，
        //我们把这个值使用完之后还要把它给移除，这就是回溯
        list.remove(list.size() - 1);
    }
}
 */

//递归方法
public class PathSum_II
{
    public int pathSum(TreeNode root, int sum)
    {
        if(root == null)
            return 0;

        return pathSumFromRoot(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }

    private int pathSumFromRoot(TreeNode root, int sum)//思路：需要另建方法从根节点开始递归。
    {
        int ret = 0;
        if(root == null) return 0;

        if(sum == root.val)
            ret++;

        ret += pathSumFromRoot(root.left, sum - root.val) + pathSumFromRoot(root.right, sum - root.val);
        return ret;
    }
}
