package com.top100.A_Array.Other;

/*
����Ŀ��
    ����һ���������� nums ��һ������k ������ͳ�Ʋ����ظ������к�Ϊk������������ĸ�����

��ʾ����
    ���룺nums = [1,1,1], k = 2
    �����2

��ʾ����
    ���룺nums = [1,2,3], k = 3
    �����2
 */
public class SubArray_560
{
    public int subarraySum(int[] nums, int k)
    {
        int len = nums.length;
        int sum = 0;
        int count = 0;
        //˫��ѭ��
        for (int i = 0; i < len; ++i)
        {
            for (int j = i; j < len; ++j)
            {
                sum += nums[j];
                //���ַ�������������
                if (sum == k)
                    count++;
            }

            sum = 0;//�ǵù��㣬���±���
        }
        return count;
    }
}
