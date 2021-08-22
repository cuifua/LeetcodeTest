package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;

/**
 * @Author cuifua
 * @Date 2021/7/20 14:51
 * @Version 1.0
 */
public class C_Insertion extends Sort
{
    @Override
    public void sort(Integer[] nums)
    {
        int n = nums.length;
        for(int i = 1; i < n; i++)
        {
            for(int j = i; j > 0 && less(nums[j],nums[j-1]); j--)
                swap(nums,j,j-1);
        }
    }
}