package com.top100.A_Array.Other;

/*
【题目】
    给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。

【示例】
    输入: [1,2,3,4]
    输出: [24,12,8,6]

【思路】
    原数组：       [1       2       3       4]
    左部分的乘积：   1       1      1*2    1*2*3
    右部分的乘积： 2*3*4    3*4      4      1
    结果：        1*2*3*4  1*3*4   1*2*4  1*2*3*1


提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
说明: 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 */
public class productExceptSelf_238
{
    public int[] productExceptSelf(int[] nums)
    {
        int len = nums.length;

        int[] L = new int[len];
        int[] R = new int[len];
        int[] ans = new int[len];

        L[0] = 1;
        for(int i = 1; i < len; i++)
            L[i] = nums[i-1] * L[i-1];

        R[len-1] = 1;
        for(int i = len-2; i >= 0; i--)
            R[i] = nums[i+1] * R[i+1];

        for(int i = 0; i < len; i++)
            ans[i] = L[i] * R[i];

        return ans;
    }
}
