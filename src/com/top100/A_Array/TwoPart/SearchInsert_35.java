package com.top100.A_Array.TwoPart;

import org.junit.Test;

/*
 * 【题目】【---------涉及到排序的就可以使用二分法------------】
 *       给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 *       如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *       你可以假设数组中无重复元素。
 * 【例题】
 *      输入: [1,3,5,6], 5
 *      输出: 2
 *
 *      输入: [1,3,5,6], 7
 *      输出: 4
 * 【思路】
 */
public class SearchInsert_35
{
    public int searchInsert(int[] nums, int target)
    {
        int len = nums.length;
        // 如果数组里最后一个索引的值都比目标值小，那么相当于将目标值加到最后面，即返回len
        if (nums[len - 1] < target)
            return len;

        // 程序走到这里一定有 target <= nums[len - 1]
        int left = 0;
        int right = len - 1;

        // 在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
        while (left < right)
        {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target)
                left = mid + 1;//下一轮搜索的区间是 [mid + 1..right]

            else
                right = mid;    //下一轮搜索的区间是 [left..mid]
        }
        return left;            //or  return right
    }

    @Test
    public void test()
    {
        int[] ts = {1,3,5,6};
        int ta = 7;
        System.out.println(searchInsert(ts,ta));
    }
}

/*此方法时间复杂度为n,应该用二分法，降为logN
public int search (int[] nums, int target)
    {
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] >= target)
            {
                return i;
            }
        }
        return nums.length;
    }
 */

