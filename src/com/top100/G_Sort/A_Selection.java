package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;

/**
 * @Author cuifua
 * @Date 2021/7/20 14:38
 * @Version 1.0
 */
public class A_Selection extends Sort
{
    @Override
    public void sort(Integer[] nums)
    {
        int n = nums.length;
        for(int i = 0; i < n; i++)
        {
            int min = i;
            for(int j = i+1; j < n; j++)
            {
                if(less(nums[j], nums[min]))
                    min = j;
            }
            swap(nums, i, min);
        }
    }
}
