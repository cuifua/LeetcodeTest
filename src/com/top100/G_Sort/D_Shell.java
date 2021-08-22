package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;

/**
 * @Author cuifua
 * @Date 2021/7/20 14:55
 * @Version 1.0
 */
public class D_Shell extends Sort
{
    @Override
    public void sort(Integer[] nums)
    {
        int n = nums.length;
        int h = 1;

        while (h < n/3)
        {
            h = 3*h + 1;//1,4,9,13
        }

        while (h >= 1)
        {
            for(int i = h; i < n; i++)
            {
                for(int j = i; j > 0 && less(nums[j],nums[j-h]); j -= h)
                    swap(nums,j,j-h);
            }

            h = h/3;
        }
    }
}
