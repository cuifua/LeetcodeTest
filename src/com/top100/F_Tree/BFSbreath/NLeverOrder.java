package com.top100.F_Tree.BFSbreath;
/*
【题目】给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
      树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
【例题】输入：root = [1,null,3,2,4,null,5,6]
       输出：[[1],[3,2,4],[5,6]]
【例题】输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
      输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Node
{
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NLeverOrder
{
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> NLever (Node root)
    {
        Queue<Node> queue = new ArrayDeque<>();
        if(root != null)    queue.offer(root);

        List<Integer> path = new ArrayList<>();
        int n = queue.size();
        while(!queue.isEmpty())
        {
            for(int i = 0 ; i < n; i++)
            {
                Node curr = queue.poll();
                path.add(curr.val);
                for(Node no : curr.children)
                {
                    if(no != null)   queue.offer(no);
                }
                res.add(path);
            }

        }
        return res;
    }
}
