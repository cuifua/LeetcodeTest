package com.top100.D_QueueStack;

import com.top100.E_LinkedList.NoClass.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
����Ŀ��
    ����һ���������飬ÿ�������Ѿ����������С�
    ���㽫��������ϲ���һ�����������У����غϲ��������

��ʾ�� 1��
    ���룺lists = [[1,4,5],[1,3,4],[2,6]]
    �����[1,1,2,3,4,4,5,6]
    ���ͣ������������£�
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    �����Ǻϲ���һ�����������еõ���
    1->1->2->3->4->4->5->6
 */
public class KListSort_23
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        if(lists.length == 0)  return null;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;//����С��
            }
        });

        //��K�������ͷ��������С��
        for(ListNode node : lists)
        {
            if(node != null)
                queue.offer(node);
        }

        while(! queue.isEmpty())
        {
            ListNode minNode = queue.poll();//��ȡ��С������С�Ľ��
            p.next = minNode;//����ͷ�����϶�����С��

            if(minNode.next != null)
                queue.add(minNode.next);

            p = p.next;
        }
        return dummy.next;
    }
}
