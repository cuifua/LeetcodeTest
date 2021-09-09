package com.top100.A_Array.Other;

/*
����Ŀ��
    ����һ��������ɫ����ɫ����ɫ��һ��n ��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�
    �����У�����ʹ������ 0��1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��

��ʾ����
    ���룺nums = [2,0,2,1,1,0]
    �����[0,0,1,1,2,2]

��ʾ����
    ���룺nums = [2,0,1]
    �����[0,1,2]

��˼·��
    ��ǰ�������������0����ǰ�棬start++
    ����2��������end--
    ���1���ùܣ���Ȼ��Ȼ�Ͱ���˳����
 */
public class SortColors_75
{
    public void sortColors(int[] nums)
    {
        int len  = nums.length;
        int start = 0;
        int end = len-1;
        int i = 0;

        while(i < len)
        {
            if(nums[i] == 0 && i > start)
            {
                swap(nums,i,start);
                start++;
            }
            else if(nums[i] == 2 && i < end)
            {
                swap(nums,i,end);
                end--;
            }
            else
                i++;
        }
    }

    public void swap(int[] nums, int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
