package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;

/**
 * @Author cuifua
 * @Date 2021/7/20 15:00
 * @Version 1.0
 */
public class F_Merge extends Sort
{
    //合并时，需要辅助数组，空间复杂度为 O(N)
    private Integer[] aux;

    //归并方法：将数组中两个已经排序的部分归并成一个。
    //l需要合并的数组左端，m中点，h需要合并的数组右端
    private void merge(int[] nums, int l, int m, int h)
    {
        int i = l, j = m+1;
        for(int k = l; k <= h; k++)
            aux[k] = nums[k];//将数据复制到辅助数组

        for(int k = l; k <= h; k++)
        {
            if(i > m)
                nums[k] = aux[j++];
            else if(j > h)
                nums[k] = aux[i++];
            else if(aux[i]<=aux[j])
                nums[k] = aux[i++];
            else
                nums[k] = aux[j++];
        }
    }

    //将一个大数组分成两个小数组去求解。
    //因为每次都将问题对半分成两个子问题，这种对半分的算法复杂度一般为 O(NlogN)。
    @Override
    public void sort(int[] nums)
    {
        aux = new Integer[nums.length];
        sort(nums, 0, nums.length-1);
    }

    private void sort(int[] nums, int l, int h)
    {
        if(h<=l)
            return;

        int mid = l + (h - l)/2;
        sort(nums, l, mid);
        sort(nums, mid+1, h);
        merge(nums, l, mid, h);
    }
}
