package com.top100.A_Array.Other;

import java.util.HashSet;
import java.util.Set;

/*
【题目】
    给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    请你设计并实现时间复杂度为O(n) 的算法解决此问题。
【示例】
    输入：nums = [100,4,200,1,3,2]
    输出：4
    解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4

【示例】
    输入：nums = [0,3,7,2,5,8,4,6,0,1]
    输出：9
【思路】
    如果我们知道了每一个连续序列的左边界，并且知道以它为左边界的连续序列的长度。进而就可以知道所有连续序列的长度。在其中取最大值即为结果。
    但都有哪些数可以成为连续序列的左边界呢？

    设想，如果num为一个左边界，那么num - 1就不应该存在于数组中（因为如果num - 1存在于数组中，num - 1又与num连续，所以num不可能是连续序列的左边界）。
    因此如果一个数字num满足：num-1不存在于数组中。这个数字num就可以成为连续序列的左边界。

    具体的算法流程如下；
        准备一个HashSet，将所有元素入set，之后遍历数组中的每一个数num
        如果num - 1存在于set中，那么num不可能是左边界，直接跳过
        如果num - 1不存在于set中，那么num会是一个左边界，我们再不断地查找num+1、num+2......是否存在于set中，来看以num为左边界的连续序列能有多长
        在上述遍历中，我们知道了对于每一个可能的左边界，能扩出的最长连续序列的长度，再在这些长度中取最大即为结果。
 */
public class LongestSub_128
{
    public int longestConsecutive(int[] nums)
    {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        int longest = 0;
        for(int num : nums)
        {
            if(set.contains(num-1))//如果num - 1存在于set中，那么num不可能是左边界，直接跳过
                continue;
            else //如果num - 1不存在于set中，那么num会是一个左边界，我们再不断地查找num+1、num+2......是否存在于set中
            {
                int len = 0;
                while(set.contains(num++))   len++;
                longest = Math.max(longest,len);
            }
        }
        return longest;
    }
}
