package com.top100.A_Array.TwoPoint;
/*
【题目】
    给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
    使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
【例题】
    输入：nums = [-1,0,1,2,-1,-4]
    输出：[[-1,-1,2],[-1,0,1]]
【思路】
    1.特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []。
    2.对数组进行排序。
    3.遍历排序后数组：
         若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
         对于重复元素：跳过，避免出现重复解
         令左指针 L=i+1，右指针 R=nums.length-1,当 L<R 时，执行循环：
         当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
         若和大于 0，说明 nums[R]太大，R 左移
         若和小于 0，说明 nums[L]太小，L 右移
 */

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15
{
    public List<List<Integer>> threesum(int[] nums)
    {
        List<List<Integer>> fins = new ArrayList<>();
        Arrays.sort(nums);                                 //对数组排序，从小到大

        for (int i = 0; i < nums.length; ++i)
        {
            if(nums[i] > 0)  return fins;                  //若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
            if(i > 0 && nums[i] == nums[i-1])  continue;   //对于重复元素：跳过，避免出现重复解


            int L = i+1, R = nums.length - 1;  //i从0索引开始，L从1索引开始，R从最后索引一个开始
            while (L < R)
            {
                int temp = nums[i] + nums[L] + nums[R];
                if(temp == 0)
                {
                    List<Integer> fin = new ArrayList<>();
                    fin.add(nums[i]);
                    fin.add(nums[L]);
                    fin.add(nums[R]);
                    fins.add(fin);
                    while(L < R && nums[L] == nums[L + 1])  ++L;  //去重
                    while(L < R && nums[R - 1] == nums[R])  --R;  //去重

                    ++ L;
                    -- R;
                }
                else if(temp < 0)    ++L;
                else if(temp > 0)    --R;
            }
        }
        return fins;
    }



    @Test
    public void test()
    {
        int[] ts = {-1,0,1,2,-1,-4};
        System.out.println(threesum(ts));
    }
}

