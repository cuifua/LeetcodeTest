package com.top100.E_LinkedList.Recursion;

import com.top100.E_LinkedList.NoClass.ListNode;

/**
 * 【题目】
 *      存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *      返回同样按升序排列的结果链表
 * 【例题】
 *      输入：head = [1,1,2,3,3]
 *      输出：[1,2,3]
 * 【思路】
 */
public class deleteDuplicates_83
{
    public ListNode deleteDuplicates(ListNode head)
    {
        if(head == null || head.next == null)
            return head;

        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
