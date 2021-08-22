package com.top100.E_LinkedList.FastSlow;

import com.top100.E_LinkedList.NoClass.ListNode;

/**
 * @Author cuifua
 * @Date 2021/7/7 11:40
 * @Version 1.0
 */
public class RemoveEndK_19
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode realHead = new ListNode(0,head);
        ListNode fast = realHead;
        ListNode slow = realHead;

        int i = 0;

        while(fast != null)
        {
            if(i <= n)             //先让fast走到要删除的结点
            {
                fast = fast.next;
                i++;
                continue;
            }

            fast = fast.next;       //此时fast走到末尾的null
            slow = slow.next;       //slow此时在要被删的节点的前一个节点
        }

        slow.next = slow.next.next;  //此时slow在被删的前一个，现在把slow下一个（就是要被删的）赋给下一个的下一个，删除要删的

        return realHead.next;
    }
}
