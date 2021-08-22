package com.top100.I_Backtracking;
/*
【题目】  实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
         如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
         必须 原地 修改，只允许使用额外常数空间。

【例题】   输入：nums = [1,2,3]
         输出：[1,3,2]

         输入：nums = [3,2,1]
         输出：[1,2,3]

        输入：nums = [1,1,5]
        输出：[1,5,1]
 */

import org.junit.Test;

public class NextPermutation
{
    public void res (int[] nums)
    {
        int i = nums.length - 2;

        while( i >=0 && nums[i] >= nums[i+1])        //只要后一个比前一个小，就继续往前，旨在从后往前直到不能降序为止，比如【1，4，2，6，4，3】
        {                                           //3比4小，4比6小，但6不比2小，停，此时nums[i]=2
            i--;
        };

        if(i >= 0)
        {
            int j = nums.length - 1;                //j表示该数组最后一个数
            while( j >=0 && nums[i] >= nums[j])     //j从最后一个往前走，直到找到一个比i大的数，两数交换
            {
                j--;
            }
            swap(nums,i,j);
        }
        reserve(nums, i+1);                     //将nums[]数组的从i开始往后的数重新从小到大排序，
    }

    public void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void reserve(int[] nums,int start)
    {
        int L = start,R = nums.length - 1;
        while(L < R)
        {
            swap(nums,L++,R--);
        }
    }







    @Test
    public void test()
    {
        int[] test = {1,2,3} ;
        res(test);
    }
}

