package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;
import org.junit.Test;

/**
 * @Author cuifua
 * @Date 2021/7/20 15:00
 * @Version 1.0
 */
public class F_Merge
{
    public void mergeSort(int[] nums,int left, int right)// 需要辅助数组，空间复杂度为 O(N)
    {
        if(left < right)
        {
            int mid = left + (right - left)/2;
            mergeSort(nums,0,mid);//将左边部分继续分
            mergeSort(nums,mid+1,right);//将右边部分继续分

            merge(nums, left, mid, right);//合并
        }
    }

    public void merge(int[] nums,int left, int mid, int right)// 将分开的数开始有序合并
    {
        int i = left;      //3 4 6 8    7 4 1  ---->这里的3相当于i, 7相当于j
        int j = mid + 1;
        int index = left;//临时数组的下标
        int[] temp = new int[nums.length];

        while(i <= mid && j <=right)
        {
            if(nums[i] < nums[j])  //如果3小于7，那么临时数组里面填的就是nums[i]
                temp[index++] = nums[i++];

            else
                temp[index++] = nums[j++];
        }


        while(i <= mid) temp[index++] = nums[i++];//如果左边的没合并进去，就是3左边的

        while(j <= right)  temp[index++] = nums[j++];   //如果右边的没合并进去，就是1右边的

        //将temp里的数填充到数组的指定位置
        for (int m = left; m <=right; m++)
            nums[m]=temp[m];
    }





    @Test
    public void Mergetest()
    {
        int[] nums = {49, -38, 65, -97, 76, 13, 27, 50};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println("排好序的数组：");
        for (int e : nums)
            System.out.print(e + " ");
    }
}
