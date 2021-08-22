package com.top100.A_Array.RemoveDup;

/*
 * 【题目】
 * 【例题】
 * 【思路】
 */
public class RemoveDuplicatesII_80
{
    public int removeDuplicates(int[] nums)
    {
        return process(nums,2);
    }

    public int process(int[] nums, int k)
    {
        int index = 0;
        for(int num : nums)
        {
            if(index < k || nums[index-k] != num)
                nums[index++] = num;
        }
        return index;
    }
}
