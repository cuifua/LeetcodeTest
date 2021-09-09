package com.top100.D_QueueStack;

import com.top100.E_LinkedList.NoClass.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
【题目】
    给你一个链表数组，每个链表都已经按升序排列。
    请你将所有链表合并到一个升序链表中，返回合并后的链表。

【示例 1】
    输入：lists = [[1,4,5],[1,3,4],[2,6]]
    输出：[1,1,2,3,4,4,5,6]
    解释：链表数组如下：
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    将它们合并到一个有序链表中得到。
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
                return o1.val - o2.val;//降序小堆
            }
        });

        //将K个链表的头结点加入最小堆
        for(ListNode node : lists)
        {
            if(node != null)
                queue.offer(node);
        }

        while(! queue.isEmpty())
        {
            ListNode minNode = queue.poll();//获取最小堆上最小的结点
            p.next = minNode;//虚拟头结点接上堆里最小的

            if(minNode.next != null)
                queue.add(minNode.next);

            p = p.next;
        }
        return dummy.next;
    }
}
