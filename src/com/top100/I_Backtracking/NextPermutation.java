package com.top100.I_Backtracking;
/*
����Ŀ��  ʵ�ֻ�ȡ ��һ������ �ĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�
         �����������һ����������У��������������г���С�����У����������У���
         ���� ԭ�� �޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣

�����⡿   ���룺nums = [1,2,3]
         �����[1,3,2]

         ���룺nums = [3,2,1]
         �����[1,2,3]

        ���룺nums = [1,1,5]
        �����[1,5,1]
 */

import org.junit.Test;

public class NextPermutation
{
    public void res (int[] nums)
    {
        int i = nums.length - 2;

        while( i >=0 && nums[i] >= nums[i+1])        //ֻҪ��һ����ǰһ��С���ͼ�����ǰ��ּ�ڴӺ���ǰֱ�����ܽ���Ϊֹ�����硾1��4��2��6��4��3��
        {                                           //3��4С��4��6С����6����2С��ͣ����ʱnums[i]=2
            i--;
        };

        if(i >= 0)
        {
            int j = nums.length - 1;                //j��ʾ���������һ����
            while( j >=0 && nums[i] >= nums[j])     //j�����һ����ǰ�ߣ�ֱ���ҵ�һ����i���������������
            {
                j--;
            }
            swap(nums,i,j);
        }
        reserve(nums, i+1);                     //��nums[]����Ĵ�i��ʼ����������´�С��������
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

