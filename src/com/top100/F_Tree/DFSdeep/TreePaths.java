package com.top100.F_Tree.DFSdeep;

import com.top100.F_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
����Ŀ�� ����һ�����������������дӸ��ڵ㵽Ҷ�ӽڵ��·����
        ˵��:Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣

�����⡿
        ����:

           1
         /   \
        2     3
         \
          5

        ���: ["1->2->5", "1->3"]
 */
public class TreePaths
{
    public List<String> treepaths (TreeNode root)
    {
        List<String> res = new ArrayList<>();
        dfs(root,"",res);
        return res;

    }

    private void dfs (TreeNode root, String path, List<String> res)
    {
        //���Ϊ�գ�ֱ�ӷ���
        if(root == null)       return;

        //�����Ҷ�ӽڵ㣬˵���ҵ���һ��·�����������뵽res��
        if(root.left == null && root.right == null)
        {
            res.add(path + root.val);
            return;
        }

        //�������Ҷ�ӽڵ㣬�ڷֱ�������������ӽڵ�
        else
        {
            dfs(root.left,path+root.val+"->",res);
            dfs(root.right,path+root.val+"->",res);
        }
    }
}
