package com.top100.E_LinkedList.NoClass;

import java.util.ArrayList;

/*
 * 【题目】
 *      请判断一个链表是否为回文链表。
 * 【例题】
 * 【思路】
 *      1. 将链表转换为数组。
 *      2. 使用双指针法。
 */
public class isPalindrome_234
{
    public boolean isPalindrome(ListNode head)
    {
        //步骤1、不管三七二十一，先判空
        if(head == null) return true;

        //步骤2、把链表的数挪进数组里
        ArrayList<Integer> list = new ArrayList<>();
        while(head != null)
        {
            list.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;

        //步骤3、逐步判断第一个和最后一个，第二个和倒数第二个
        while(left < right)
        {
            if(!list.get(left).equals(list.get(right)))
                return false;

            left ++;
            right --;
        }

        return true;
    }
}
