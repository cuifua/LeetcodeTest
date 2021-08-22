package com.top100.B_Hash.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 【题目】
 *      和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 *      现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 *      数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。。
 * 【例题】
 *      输入：nums = [1,3,2,2,5,2,3,7]
 *      输出：5
 *      解释：最长的和谐子序列是 [3,2,2,2,3]
 *
 *      输入：nums = [1,2,3,4]
 *      输出：2
 *
 *      输入：nums = [1,1,1,1]
 *      输出：0
 * 【思路】 look at the second methond
 *      https://leetcode-cn.com/problems/longest-harmonious-subsequence/solution/zui-chang-he-xie-zi-xu-lie-by-leetcode/
 */
public class findLHS_594
{
    public int find(int[] nums)
    {
        Map<Integer,Integer> map = new HashMap<>();

        //put all the numbers in this map
        for(int num : nums)
            map.put(num,map.getOrDefault(num,0)+1);

       int longest = 0;
       for(int num : map.keySet())
       {
           if(map.containsKey(num+1))
               longest = Math.max(longest,map.get(num)+map.get(num+1));
       }
    return longest;
    }

}
