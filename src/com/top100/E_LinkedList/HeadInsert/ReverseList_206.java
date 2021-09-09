package com.top100.E_LinkedList.HeadInsert;
import com.top100.E_LinkedList.NoClass.ListNode;

//【题目】反转一个单链表。
//输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL


public class ReverseList_206
{
    /*
    public ListNode reservelist(ListNode head)
    {
        ListNode pre = null;
        ListNode curr = head;

        while(curr != null)
        {
            ListNode temp = curr.next;  //先将目前指向的结点存储在临时结点
            curr.next = pre;            //目前的结点指向前一个
            pre = curr;                 //前一个结点来到目前的结点，pre 和cur 重合
            curr = temp;                //目前的结点往下走，将刚刚临时节点存储的值拿过来
        }
        return pre;
    }

     */
    //递归法
    public ListNode reverseList(ListNode head)
    {
        return reverse(null,head);
    }

    private static ListNode reverse(ListNode pre,ListNode cur)
    {
        if(cur==null) return pre;

        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur,next);
    }
}

