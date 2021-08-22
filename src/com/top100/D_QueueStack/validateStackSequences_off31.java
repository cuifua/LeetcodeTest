package com.top100.D_QueueStack;

import java.util.Stack;

/*
 * 【题目】
 *      输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 *      假设压入栈的所有数字均不相等。
 *      例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 *      但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * 【例题】
 *      输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 *      输出：false
 *      解释：1 不能在 2 之前弹出。
 * 【思路】
 *      https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/solution/mian-shi-ti-31-zhan-de-ya-ru-dan-chu-xu-lie-mo-n-2/
 *      看动画，超级清晰
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
