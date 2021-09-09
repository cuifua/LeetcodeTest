package com.top100.A_Array.TwoPart;

/*
【题目】
    整数数组 nums 按升序排列，数组中的值 互不相同 。
    在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
    使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
    例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。

    给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。


【示例 1】
    输入：nums = [4,5,6,7,0,1,2], target = 0
    输出：4

【示例2：】
    输入：nums = [4,5,6,7,0,1,2], target = 3
    输出：-1

【思路】
    //如果中间的数小于最右边的数，则右半段是有序的，
    //若中间数大于最右边数，则左半段是有序的
    //我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了
 */
public class SearchRoll_33
{
    public int search(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length-1;

        while(left <= right)
        {
            int mid = left + (right-left)/2;

            if(nums[mid] == target)
                return mid;

            else if(nums[mid] < nums[right])//右边已经有序了
            {
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid -1;
            }

            else//左边有序
            {
                if(target >= nums[left] && target < nums[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }
        }
        return -1;
    }
}
