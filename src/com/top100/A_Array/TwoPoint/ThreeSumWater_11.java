package com.top100.A_Array.TwoPoint;

/*
 * 【题目】
 *      给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，
 *      垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 【例题】
 *      输入：[1,8,6,2,5,4,8,3,7]
 *      输出：49
 *      解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为===49。
 * 【思路】
 *      双指针，横坐标长缩小，那么就得寻求最高的高，左右指针缩进
 */
public class ThreeSumWater_11
{
    public int water(int[] height)
    {
        int L = 0, R = height.length-1;
        int res = 0;

        while(L < R)
        {
            int h = Math.min(height[L],height[R]);
            res = Math.max(res,(R-L)*h);

            if(height[L] < height[R])
                ++L;
            else
                --R;
        }
        return res;
    }
}
