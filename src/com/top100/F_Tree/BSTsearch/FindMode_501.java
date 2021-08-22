package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
【题目】给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

【例题】
        给定 BST [1,null,2,2],

           1
            \
             2
            /
           2
        返回[2].
 */
public class FindMode_501
{
        List<Integer> mList = new ArrayList<>();
        int curent = 0;//表示当前节点的值
        int count = 0;//表示当前节点的数量
        int maxCount = 0;//最大的重复数量

        public int[] findMode(TreeNode root)
        {
            inOrderTraversal(root);
            int[] res = new int[mList.size()];

            for (int i : mList)
                res[i] = mList.get(i);

            return res;
        }

        //递归方式
        public void inOrderTraversal(TreeNode node)
        {
            if (node == null)
            return;

            inOrderTraversal(node.left);                            //遍历左子树
            int nodeValue = node.val;
            if (nodeValue == curent)   count++;                     //如果节点值等于curent，count就加1
            else                                                    //否则，就表示遇到了一个新的值，curent和count都要重新赋值
                {
                    curent = nodeValue;
                    count = 1;
                 }

            if (count == maxCount)    mList.add(nodeValue);         //如果count == maxCount，就把当前节点加入到集合中
            else if (count > maxCount)                              //否则，当前节点的值重复量是最多的，直接把list清空，然后把当前节点的值加入到集合中
            {
                mList.clear();
                mList.add(nodeValue);
                maxCount = count;
            }

            inOrderTraversal(node.right);                           //遍历右子树
        }

}
