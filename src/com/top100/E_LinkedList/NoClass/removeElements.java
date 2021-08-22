package com.top100.E_LinkedList.NoClass;
import org.junit.Test;

/*
【题目】给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。

【例题】输入：head = [1,2,6,3,4,5,6], val = 6
       输出：[1,2,3,4,5]
*/
public class removeElements
{
    public ListNode remove(ListNode head, int target)
    {
         ListNode dummy = new ListNode(0);
         dummy.next = head;

         ListNode curr = dummy;
         while(curr != null && curr.next != null)
         {
             if(curr.next.val == target)
                 curr.next = curr.next.next;
             else
                 curr = curr.next;
             
         }
         return dummy.next;
    }


    @Test
    void test()
    {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);
        ListNode t5 = new ListNode(5);
    }
}



