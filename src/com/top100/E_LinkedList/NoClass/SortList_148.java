package com.top100.E_LinkedList.NoClass;

/*
【题目】
    给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
【例题】
    输入：head = [-1,5,3,4,0]
    输出：[-1,0,3,4,5]
【思路】
    归并排序
    1、先找到中间的结点
    2、再前面排前面，后面排后面
    3、最后按照大小顺序合并
 */
public class SortList_148
{
    public ListNode sortList(ListNode head)
    {
        return sort(head, null);
    }

    private ListNode sort(ListNode start, ListNode end)
    {
        if(start == end)
            return start;

        ListNode fast = start;
        ListNode slow = start;
        while(fast != end && fast.next != end)//这一步是找到中间的结点
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = sort(slow.next, end);
        slow.next = null; // 链表判断结束的标志：末尾节点.next==null
        ListNode left = sort(start, slow);


        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2)
    {
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        if(l1.val < l2.val)
        {
            l1.next = merge(l1.next, l2);
            return l1;
        }else
        {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
