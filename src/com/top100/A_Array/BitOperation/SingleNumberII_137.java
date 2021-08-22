package com.top100.A_Array.BitOperation;

/*
 * 【题目】
 *      给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 【例题】
 *      输入：nums = [2,2,3,2]
 *      输出：3
 *
 *      输入：nums = [0,1,0,1,0,1,99]
 *      输出：99
 * 【思路】
 */
public class SingleNumberII_137
{
    public int singleNumber(int[] nums)
    {
        //最终的结果值
        int res = 0;

        //int类型有32位，统计每一位1的个数
        for (int i = 0; i < 32; i++)
        {
            //统计第i位中1的个数
            int oneCount = 0;

            for (int j = 0; j < nums.length; j++)
                oneCount += (nums[j] >>> i) & 1;

            //如果1的个数不是3的倍数，说明那个只出现一次的数字的二进制位中在这一位是1
            if (oneCount % 3 == 1)
                res |= 1 << i;
        }
        return res;
    }
}



/** 利用HashMap方法
    public int singleNumber(int[] nums)
    {
        Map<Integer, Integer> map = new HashMap<>();

        //先把数字存储到map中，其中key存储的是当前数字，value是数字的出现的次数
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        //最后在遍历map中的所有元素，返回value值等于1的
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
         {
            if (entry.getValue() == 1)
                 return entry.getKey();
         }

        return -1;
    }
 */
