package com.top100.E_LinkedList.FastSlow;

import com.top100.E_LinkedList.NoClass.ListNode;

/*
 * 【题目】 快慢指针
 *      输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *      例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * 【例题】
 *      给定一个链表: 1->2->3->4->5, 和 k = 2.
 *      返回链表 4->5.
 * 【思路】
 */
public class RemoveEndK_off22
{
    public int getKthFromEnd(ListNode head, int k)
    {
        ListNode first = head;     //first先走K步
        ListNode second = head;

        //第一个指针先走k步
        while (k-- > 0)
        {
            first = first.next;
        }

        //然后两个指针在同时前进
        while (first != null)
        {
            first = first.next;
            second = second.next;
        }

        return second.val;
    }
}
