package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author cuifua
 * @Date 2021/8/31 20:36
 * @Version 1.0
 */
public class E_QuickSort
{
    public static void quick(int[] nums,int left, int right)
    {
        if(left >= right) return;

        int L = left;
        int R = right;

        while(L < R)
        {
            while (L < R && nums[R] >= nums[left])  R--;
            while (L < R && nums[L] <= nums[left])  L++;

            if(L == R)//左右指针相遇了，参照物左边的数和参照物交换，因为能确定参照物左边的数一定比参照物小
            {
                int temp = nums[L];
                nums[L] = nums[left];
                nums[left] = temp;
            }

            else
            {
                int temp = nums[R];
                nums[R] = nums[L];
                nums[L] = temp;
            }
        }

        quick(nums,left,L-1);
        quick(nums,R+1,right);
    }


    @Test
    public void InsertTest()
    {
        int[] nums = new int[]{1,9,0,2,3,8,7};
        quick(nums,0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
