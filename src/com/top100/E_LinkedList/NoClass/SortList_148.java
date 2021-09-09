package com.top100.E_LinkedList.NoClass;

/*
����Ŀ��
    ���������ͷ��� head ���뽫�䰴 ���� ���в����� ����������
�����⡿
    ���룺head = [-1,5,3,4,0]
    �����[-1,0,3,4,5]
��˼·��
    �鲢����
    1�����ҵ��м�Ľ��
    2����ǰ����ǰ�棬�����ź���
    3������մ�С˳��ϲ�
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
        while(fast != end && fast.next != end)//��һ�����ҵ��м�Ľ��
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = sort(slow.next, end);
        slow.next = null; // �����жϽ����ı�־��ĩβ�ڵ�.next==null
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
