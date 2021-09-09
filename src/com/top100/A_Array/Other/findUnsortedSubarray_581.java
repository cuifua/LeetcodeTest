package com.top100.A_Array.Other;
/*
����Ŀ��
    ����һ���������� nums ������Ҫ�ҳ�һ�� ���������� �����������������������������ô�������鶼���Ϊ��������
    �����ҳ���������� ��� �����飬��������ĳ��ȡ�
��ʾ����
    ���룺nums = [2,6,4,8,10,9,15]
    �����5
    ���ͣ���ֻ��Ҫ�� [6, 4, 8, 10, 9] ��������������ô���������Ϊ��������
��ʾ����
    ���룺nums = [1,2,3,4]
    �����0

��˼·��
    ������ѭ������¼���ֵΪ max���� nums[i] < max, �����λ�� i ��Ҫ����, ѭ����������¼��Ҫ���������λ�� i Ϊ high;
    ͬ�����ҵ���ѭ������¼��СֵΪ min, �� nums[i] > min, �����λ�� i ��Ҫ������ѭ����������¼��Ҫ��������Сλ�� i Ϊ low.
 */
public class findUnsortedSubarray_581
{
    public int findUnsortedSubarray(int[] nums)
    {
        int len = nums.length;
        if(len <= 1) return 0;

        int high = 0;
        int low = len-1;
        int max = nums[0];
        int min = nums[len-1];

        for(int i = 1; i < len; i++)
        {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len-1-i]);

            if(nums[i] < max)
                high = i;

            if(nums[len-1-i] > min)
                low = len-1-i;
        }
        return high > low ? high - low + 1 : 0;
    }
}
