package com.top100.H_Greedy;

/**
 * @Author cuifua
 * @Date 2021/9/3 19:56
 * @Version 1.0
 */
/*
【题目】
    给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个下标。

【示例】
    输入：nums = [2,3,1,1,4]
    输出：true
    解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

【示例2】
    输入：nums = [3,2,1,0,4]
    输出：false
    解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

 */
public class JumpGame_55
{
    public boolean canjump(int[] nums)
    {

        int len = nums.length;
        if(len <= 1)   return true;

        int maxStep = nums[0];
        for (int i = 1; i < len-1; i++)
        {
            if (i <= maxStep)//如果当前位置在最大位置之内，表示可达,在此基础上才能算自己所在位置和自己能跳跃位置里谁更大一点
                maxStep = Math.max(maxStep,nums[i]+i);
        }
        return maxStep >= len-1;
    }
}
