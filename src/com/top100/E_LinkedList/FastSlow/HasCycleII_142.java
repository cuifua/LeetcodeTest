package com.top100.E_LinkedList.FastSlow;

import com.top100.E_LinkedList.NoClass.ListNode;

/*
����Ŀ��
    ����һ��������������ʼ�뻷�ĵ�һ���ڵ㡣��������޻����򷵻�null��
    Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���ע�⣬pos ���������ڱ�ʶ�����������������Ϊ�������ݵ������С�

    ˵�����������޸ĸ���������
 */
public class HasCycleII_142
{
    public ListNode detectCycle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;

        //�����뻷ǰa,����b
        while(true)
        {
            if(fast == null || fast.next == null)  return null;

            fast = fast.next.next;//fast��2s��
            slow = slow.next;//slow��s��

            if(fast == slow)  break;//��һ��������fast���� 2s = a + nb
        }

        fast = head;//fast���»ص�ͷ�����Ѿ��ڻ��ڵ�slow�Ա�����
        while(slow != fast)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
