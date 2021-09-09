package com.top100.A_Array.TwoPart;
/* ����Ŀ��
       ����һ�������������š��е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
       ��������в�����Ŀ��ֵ target������[-1, -1]��
       �������Ʋ�ʵ��ʱ�临�Ӷ�ΪO(log n)���㷨�����������
   �����⡿
       ���룺nums = [5,7,7,8,8,10], target = 8
       �����[3,4]

       ���룺nums = [5,7,7,8,8,10], target = 6
       �����[-1,-1]

 */

import org.junit.Test;

public class SearchRange_34
{
    public int[] search (int[] nums, int target)
    {
        int len = nums.length;
        if(len == 0)
        {
            return new int[] {-1,-1};
        }

        int firstPostion = first(nums,target);

        if (firstPostion == -1)
            return new int[] {-1,-1};

        int lastPostion = last(nums,target);

        return new int[] {firstPostion,lastPostion};
    }

    private int first(int[] nums,int target)   //�ҳ���һ������
    {
        int left = 0;
        int right = nums.length -1;
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)              //��һ����������Ϊ[mid+1,right]
                left = mid + 1;

            else if(nums[mid] > target)          //��һ����������Ϊ[left,mid - 1]
                right = mid - 1;

            else                //��һ����������Ϊ[left,mid]    PS:Ϊʲô��һ��������ǰ���أ���Ϊ������ҵ���targe�ĵ�һ����������Ȼ������С����
                right = mid;
        }
       if(nums[left] == target)    return left;
       return -1;
    }

    private int last(int[] nums, int target)       //�ҳ����һ������
    {
        int left = 0;
        int right = nums.length - 1;
        while(left < right)
        {
            int mid = left + (right -left + 1) / 2;
            if(nums[mid] > target)                 //��һ����������Ϊ[left,mid - 1]
                right = mid - 1;

            else if(nums[mid] < target)           //��һ����������Ϊ[mid,right]
                left = mid + 1;

            else                                    //��һ����������Ϊ[mid + 1,right]
                left = mid;

        }
        return left;
    }




    @Test
    public void test()
    {
        int[] ts = {5,7,7,8,8,10};
        System.out.println(search(ts,8));
    }
}
