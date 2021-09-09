package com.top100.E_LinkedList.FastSlow;
import com.top100.E_LinkedList.NoClass.ListNode;
/*
 * 【题目】
 *     给定一个链表，判断链表中是否有环。
 *     如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 *     为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 *     如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *     如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 【例题】
 *      输入：head = [3,2,0,-4], pos = 1
 *      输出：true
 *      解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 【思路】
 *       使用快慢指针，快的走两步，慢的走一步
 *       为什么要这么用，【因为快的进了环，就永远也出不去了，那么慢的迟早会追上快的】
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

/**   HashSet【不允许重复】-------------------------------------------
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
