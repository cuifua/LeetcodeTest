package com.top100.E_LinkedList.Recursion;

import com.top100.E_LinkedList.NoClass.ListNode;

/**
 * 【题目】【递归！！】
 *      给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *      你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 【例题】
 *      输入：head = [1,2,3,4]
 *      输出：[2,1,4,3]
 * 【思路】
 */
public class swapPairs_24
{
    public ListNode swap(ListNode head)
    {
        return DiGui(head);
    }
    // [a b][c d][e
    public ListNode DiGui(ListNode node)
    {
        //不管三七二十一，上来先判断空
        if(node == null)
            return null;

        ListNode a = node;
        ListNode b = node.next;
        if(b == null)   return a;  //如果出现[e 单独的情况
        ListNode c = b.next;       //一定要设置一个结点来保存b的下一个，要不然b逆向指回a后，原来指向的c以及后面的链表都丢失了

        //步骤1、开始逆向操作,b逆向指回a
        b.next = a;

        //步骤3、此时a应该指的是后一组[c  d]中交换完的d
        a.next = DiGui(c);//递归括号里的应该是下一次递归开始的，就是刚刚怕丢失，先临时保存的c

        //步骤2、这个递归结束，应该返回的是表头,[a b]逆向后是[b a]
        return b;
    }
}
