package com.top100.A_Array.Other;

/*
【题目】
    给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。

【示例】
    输入：nums = [2,0,2,1,1,0]
    输出：[0,0,1,1,2,2]

【示例】
    输入：nums = [2,0,1]
    输出：[0,1,2]

【思路】
    从前往后遍历，遇到0换到前面，start++
    遇到2换到后面end--
    最后1不用管，自然而然就按照顺序了
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
