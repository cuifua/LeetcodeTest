package com.top100.E_LinkedList.Recursion;

import com.top100.E_LinkedList.NoClass.ListNode;

/**
 * 【题目】
 *      将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 【例题】
 *      输入：l1 = [1,2,4], l2 = [1,3,4]
 *      输出：[1,1,2,3,4,4]
 * 【思路】
 */
public class mergeTwoLists_21
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if(l1.val <= l2.val)
        {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else
        {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
