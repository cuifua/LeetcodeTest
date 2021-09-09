package com.top100.E_LinkedList.HeadInsert;
import com.top100.E_LinkedList.NoClass.ListNode;

//����Ŀ����תһ��������
//����: 1->2->3->4->5->NULL
//���: 5->4->3->2->1->NULL


public class ReverseList_206
{
    /*
    public ListNode reservelist(ListNode head)
    {
        ListNode pre = null;
        ListNode curr = head;

        while(curr != null)
        {
            ListNode temp = curr.next;  //�Ƚ�Ŀǰָ��Ľ��洢����ʱ���
            curr.next = pre;            //Ŀǰ�Ľ��ָ��ǰһ��
            pre = curr;                 //ǰһ���������Ŀǰ�Ľ�㣬pre ��cur �غ�
            curr = temp;                //Ŀǰ�Ľ�������ߣ����ո���ʱ�ڵ�洢��ֵ�ù���
        }
        return pre;
    }

     */
    //�ݹ鷨
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

