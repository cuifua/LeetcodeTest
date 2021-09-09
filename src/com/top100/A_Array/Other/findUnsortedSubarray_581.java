package com.top100.A_Array.Other;
/*
【题目】
    给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
    请你找出符合题意的 最短 子数组，并输出它的长度。
【示例】
    输入：nums = [2,6,4,8,10,9,15]
    输出：5
    解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
【示例】
    输入：nums = [1,2,3,4]
    输出：0

【思路】
    从左到右循环，记录最大值为 max，若 nums[i] < max, 则表明位置 i 需要调整, 循环结束，记录需要调整的最大位置 i 为 high;
    同理，从右到左循环，记录最小值为 min, 若 nums[i] > min, 则表明位置 i 需要调整，循环结束，记录需要调整的最小位置 i 为 low.
 */
public class findUnsortedSubarray_581
{
    public int findUnsortedSubarray(int[] nums)
    {
        int len = nums.length;
        if(len <= 1) return 0;

        int high = 0;
        int low = len-1;
        int max = nums[0];
        int min = nums[len-1];

        for(int i = 1; i < len; i++)
        {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len-1-i]);

            if(nums[i] < max)
                high = i;

            if(nums[len-1-i] > min)
                low = len-1-i;
        }
        return high > low ? high - low + 1 : 0;
    }
}
