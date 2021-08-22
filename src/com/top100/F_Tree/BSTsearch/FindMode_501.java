package com.top100.F_Tree.BSTsearch;

import com.top100.F_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
����Ŀ������һ������ֵͬ�Ķ�����������BST�����ҳ� BST �е���������������Ƶ����ߵ�Ԫ�أ���

�����⡿
        ���� BST [1,null,2,2],

           1
            \
             2
            /
           2
        ����[2].
 */
public class FindMode_501
{
        List<Integer> mList = new ArrayList<>();
        int curent = 0;//��ʾ��ǰ�ڵ��ֵ
        int count = 0;//��ʾ��ǰ�ڵ������
        int maxCount = 0;//�����ظ�����

        public int[] findMode(TreeNode root)
        {
            inOrderTraversal(root);
            int[] res = new int[mList.size()];

            for (int i : mList)
                res[i] = mList.get(i);

            return res;
        }

        //�ݹ鷽ʽ
        public void inOrderTraversal(TreeNode node)
        {
            if (node == null)
            return;

            inOrderTraversal(node.left);                            //����������
            int nodeValue = node.val;
            if (nodeValue == curent)   count++;                     //����ڵ�ֵ����curent��count�ͼ�1
            else                                                    //���򣬾ͱ�ʾ������һ���µ�ֵ��curent��count��Ҫ���¸�ֵ
                {
                    curent = nodeValue;
                    count = 1;
                 }

            if (count == maxCount)    mList.add(nodeValue);         //���count == maxCount���Ͱѵ�ǰ�ڵ���뵽������
            else if (count > maxCount)                              //���򣬵�ǰ�ڵ��ֵ�ظ��������ģ�ֱ�Ӱ�list��գ�Ȼ��ѵ�ǰ�ڵ��ֵ���뵽������
            {
                mList.clear();
                mList.add(nodeValue);
                maxCount = count;
            }

            inOrderTraversal(node.right);                           //����������
        }

}
