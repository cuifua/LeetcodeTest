package com.top100.E_LinkedList.FastSlow;
import com.top100.E_LinkedList.NoClass.ListNode;
/*
 * ����Ŀ��
 *     ����һ�������ж��������Ƿ��л���
 *     �����������ĳ���ڵ㣬����ͨ���������� next ָ���ٴε���������д��ڻ���
 *     Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ����
 *     ��� pos �� -1�����ڸ�������û�л���ע�⣺pos ����Ϊ�������д��ݣ�������Ϊ�˱�ʶ�����ʵ�������
 *     ��������д��ڻ����򷵻� true �� ���򣬷��� false ��
 *
 * �����⡿
 *      ���룺head = [3,2,0,-4], pos = 1
 *      �����true
 *      ���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
 *
 * ��˼·��
 *       ʹ�ÿ���ָ�룬�����������������һ��
 *       ΪʲôҪ��ô�ã�����Ϊ��Ľ��˻�������ԶҲ����ȥ�ˣ���ô���ĳ����׷�Ͽ�ġ�
 */
public class HasCycle_141
{
    public boolean hascycle(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast)
                return true;
        }
        return false;
    }
}

/**   HashSet���������ظ���-------------------------------------------
public class HasCycle
{
    public boolean hascycle (ListNode head)
    {
        Set<ListNode> seen = new HashSet<ListNode>();

        while (head != null)
        {
            if (!seen.add(head))
                return true;
            head = head.next;
        }
        return false;
    }
}
-----------------------------------------------*/
