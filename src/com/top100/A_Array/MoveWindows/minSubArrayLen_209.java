package com.top100.A_Array.MoveWindows;

import org.junit.Test;
/*【7.3】
【题目】给定一个含有n个正整数的数组和一个正整数 target 。
       找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
       并返回其长度。如果不存在符合条件的子数组，返回 0 。
【例题】
        示例 1：
        输入：target = 7, nums = [2,3,1,2,4,3]
        输出：2
        解释：子数组[4,3]是该条件下的长度最小的子数组。

        示例 2：
        输入：target = 4, nums = [1,4,4]
        输出：1

        示例 3：
        输入：target = 11, nums = [1,1,1,1,1,1,1,1]
        输出：0
 */
class minSubArrayLen_209
{
    public int minlen(int[] nums,int target)
    {
        int left = 0;              //滑动窗口的左窗口
        int right = 0;             //滑动窗口的右窗口
        int res = nums.length+1;   //最终的结果
        int len = 0;               //记录一下子数组的长度
        int sum = 0;               //窗口内的数字之和

        while(right < nums.length)  //窗口区间[left,right)
        {
            sum += nums[right];     //更新窗口状态
            right ++;
            while (sum >= target)
            {
                len = right - left;
                res = Math.min(res,len);
                sum -= nums[left];   //左窗口的数字出去
                left ++;             //滑动窗口往右边移动
            }
        }
        return res == nums.length+1 ? 0 : res;
    }
}
