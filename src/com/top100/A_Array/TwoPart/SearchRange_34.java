package com.top100.A_Array.TwoPart;
/* 【题目】
       给定一个按照升【序排】列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
       如果数组中不存在目标值 target，返回[-1, -1]。
       你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
   【例题】
       输入：nums = [5,7,7,8,8,10], target = 8
       输出：[3,4]

       输入：nums = [5,7,7,8,8,10], target = 6
       输出：[-1,-1]

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

    private int first(int[] nums,int target)   //找出第一个索引
    {
        int left = 0;
        int right = nums.length -1;
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)              //下一轮搜索区间为[mid+1,right]
                left = mid + 1;

            else if(nums[mid] > target)          //下一轮搜素区间为[left,mid - 1]
                right = mid - 1;

            else                //下一轮搜索区间为[left,mid]    PS:为什么下一轮区间是前面呢，因为这个类找的是targe的第一个索引，自然是找最小的了
                right = mid;
        }
       if(nums[left] == target)    return left;
       return -1;
    }

    private int last(int[] nums, int target)       //找出最后一个索引
    {
        int left = 0;
        int right = nums.length - 1;
        while(left < right)
        {
            int mid = left + (right -left + 1) / 2;
            if(nums[mid] > target)                 //下一轮搜索区间为[left,mid - 1]
                right = mid - 1;

            else if(nums[mid] < target)           //下一轮搜索区间为[mid,right]
                left = mid + 1;

            else                                    //下一轮走索区间为[mid + 1,right]
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
