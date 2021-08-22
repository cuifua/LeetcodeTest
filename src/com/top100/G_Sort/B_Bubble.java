package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;

/**
 * @Author cuifua
 * @Date 2021/7/20 14:46
 * @Version 1.0
 */
public class B_Bubble extends Sort
{
    @Override
    public void sort(Integer[] nums)
    {
        int n = nums.length;
        boolean flag = true;
        for(int i = n-1; i > 0 && flag; i--)
        {
            flag = false;
            for(int j = 0; j < i; j++)
            {
                if(less(nums[j+1],nums[j]))
                {
                    swap(nums,j,j+1);
                    flag = true;
                }
            }
        }
    }
}