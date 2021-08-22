package com.top100.E_LinkedList.FastSlow;
import com.top100.E_LinkedList.NoClass.ListNode;

/*
 * 【题目】
 *      给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 【例题】
 *      输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 *      输出：Intersected at '8'
 *      解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 *      从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 *      在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 【思路】
 *      快慢指针
 */

/**-----------------------------------Hash集合用法
public class IntersectNode
{
    public ListNode intersectnode(ListNode A, ListNode B)
    {
       Set<ListNode> find = new HashSet<>();
       while(A != null)
       {
           find.add(A);
           A = A.next;
       }

       while (B != null)
       {
          if(find.contains(B))
           {
               return B;
           }
          B = B.next;
       }
    return null;
    }
}
--------------------------------------Hash集合用法 */

public class IntersectNode
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        ListNode A = headA, B = headB;
        while (A != B)
        {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
