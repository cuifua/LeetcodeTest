package com.top100.E_LinkedList.FastSlow;

import com.top100.E_LinkedList.NoClass.ListNode;

/*
 * 【题目】
 *      给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *      如果有两个中间结点，则返回第二个中间结点。
 * 【例题】
 *      输入：[1,2,3,4,5]
 *      输出：此列表中的结点 3 (序列化形式：[3,4,5]) 返回的结点值为 3 。
 * 【思路】
 *      快慢指针，一个走两步，一个走一步，一起走，快指针到尾了，满指针就到中间了
 */
public class HasCycle_mid_876
{
    public ListNode middleNode(ListNode head)
    {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
