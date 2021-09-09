package com.top100.E_LinkedList.FastSlow;

import com.top100.E_LinkedList.NoClass.ListNode;

/*
【题目】
    给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。

    说明：不允许修改给定的链表。
 */
public class HasCycleII_142
{
    public ListNode detectCycle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;

        //假设入环前a,环长b
        while(true)
        {
            if(fast == null || fast.next == null)  return null;

            fast = fast.next.next;//fast走2s步
            slow = slow.next;//slow走s步

            if(fast == slow)  break;//第一次相遇，fast走了 2s = a + nb
        }

        fast = head;//fast重新回到头结点和已经在环内的slow对比相遇
        while(slow != fast)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
