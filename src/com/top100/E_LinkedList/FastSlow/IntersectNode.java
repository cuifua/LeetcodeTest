package com.top100.E_LinkedList.FastSlow;
import com.top100.E_LinkedList.NoClass.ListNode;

/*
 * ����Ŀ��
 *      ���������������ͷ�ڵ� headA �� headB �������ҳ������������������ཻ����ʼ�ڵ㡣�����������û�н��㣬���� null ��
 * �����⡿
 *      ���룺intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 *      �����Intersected at '8'
 *      ���ͣ��ཻ�ڵ��ֵΪ 8 ��ע�⣬������������ཻ����Ϊ 0����
 *      �Ӹ��Եı�ͷ��ʼ�������� A Ϊ [4,1,8,4,5]������ B Ϊ [5,0,1,8,4,5]��
 *      �� A �У��ཻ�ڵ�ǰ�� 2 ���ڵ㣻�� B �У��ཻ�ڵ�ǰ�� 3 ���ڵ㡣
 * ��˼·��
 *      ����ָ��
 */

/**-----------------------------------Hash�����÷�
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
--------------------------------------Hash�����÷� */

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
