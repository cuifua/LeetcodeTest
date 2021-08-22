package com.top100.D_QueueStack;

import java.util.Stack;

/*
 * ����Ŀ��
 *      ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 *      ����ѹ��ջ���������־�����ȡ�
 *      ���磬���� {1,2,3,4,5} ��ĳջ��ѹջ���У����� {4,5,3,2,1} �Ǹ�ѹջ���ж�Ӧ��һ���������У�
 *      �� {4,3,5,1,2} �Ͳ������Ǹ�ѹջ���еĵ������С�
 *
 * �����⡿
 *      ���룺pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 *      �����false
 *      ���ͣ�1 ������ 2 ֮ǰ������
 * ��˼·��
 *      https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/solution/mian-shi-ti-31-zhan-de-ya-ru-dan-chu-xu-lie-mo-n-2/
 *      ����������������
 */
public class validateStackSequences_off31
{
    public boolean validate(int[] pushed, int[] popped)
    {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed)
        {
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[i])
            {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
