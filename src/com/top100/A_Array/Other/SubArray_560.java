package com.top100.A_Array.Other;

/*
【题目】
    给你一个整数数组 nums 和一个整数k ，请你统计并返回该数组中和为k的连续子数组的个数。

【示例】
    输入：nums = [1,1,1], k = 2
    输出：2

【示例】
    输入：nums = [1,2,3], k = 3
    输出：2
 */
public class SubArray_560
{
    public int subarraySum(int[] nums, int k)
    {
        int len = nums.length;
        int sum = 0;
        int count = 0;
        //双重循环
        for (int i = 0; i < len; ++i)
        {
            for (int j = i; j < len; ++j)
            {
                sum += nums[j];
                //发现符合条件的区间
                if (sum == k)
                    count++;
            }

            sum = 0;//记得归零，重新遍历
        }
        return count;
    }
}
