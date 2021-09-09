package com.top100.A_Array.BitOperation;
/*
【题目】
    给你一个整数 n ，对于0 <= i <= n 中的每个 i ，
    计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。

【示例 1】
    输入：n = 2
    输出：[0,1,1]
    解释：
    0 --> 0
    1 --> 1
    2 --> 10

【示例 2】
    输入：n = 5
    输出：[0,1,1,2,1,2]
    解释：
    0 --> 0
    1 --> 1
    2 --> 10
    3 --> 11
    4 --> 100
    5 --> 101
 */
public class CountBits_338
{
    public int[] countBits(int num)
    {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++)
        {
            //一个数的比特位1的个数先让他等于他一半的比特位量
            bits[i] = bits[i / 2];

            //如果是奇数还要加1
            if ((i & 1) == 1)
                bits[i]++;
        }
        return bits;
    }
}
