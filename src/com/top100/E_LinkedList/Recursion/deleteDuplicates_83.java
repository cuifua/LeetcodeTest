package com.top100.E_LinkedList.Recursion;

import com.top100.E_LinkedList.NoClass.ListNode;

/*
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
    /*
    public ListNode deleteDuplicates(ListNode head)
    {
        if(head == null || head.next == null)
            return head;

        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;

     */

    public ListNode deleteDuplication(ListNode pHead)
    {

        ListNode dummy = new ListNode(-1);//建一个「虚拟头节点」dummy 以减少边界判断
        ListNode tail = dummy;//使用 tail 代表当前有效链表的结尾

        while (pHead != null) //通过原输入的 pHead 指针进行链表扫描
        {
            //pHead 已经没有下一个节点，pHead 可以被保留
            //pHead 有一下个节点，但是值与 pHead 不相同，pHead 可以被保留
            if (pHead.next == null || pHead.next.val != pHead.val)
            {
                tail.next = pHead;
                tail = pHead;
            }
            // 如果 pHead 与下一节点相同，跳过相同节点（到达「连续相同一段」的最后一位）
            while (pHead.next != null && pHead.val == pHead.next.val)
                pHead = pHead.next;
            pHead = pHead.next;
        }
        tail.next = null;
        return dummy.next;
    }
}
