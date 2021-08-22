package com.top100.B_Hash.map;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 【题目】
 *      给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *      你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *      你可以按任意顺序返回答案。
 * 【例题】
 *      输入：nums = [2,7,11,15], target = 9
 *      输出：[0,1]
 *      解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 【思路】
 *      暴力解法，不可！
 */

//containsKey(key)	    检查 hashMap 中是否存在指定的 key 对应的映射关系。
//containsValue()	    检查 hashMap 中是否存在指定的 value 对应的映射关系。
//get(key)	            获取指定 key 对应对 value
public class TwoSum_01
{

    public int[] TwoSum(int[] nums, int target)
    {
        //key-->这个数的值   value-->这个数值存在的索引
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(target-nums[i]))//判断这个map里是否有【key=7】这个值
                return new int[] {map.get(target - nums[i]),i};//获取【key=7】这个值的索引

            map.put(nums[i],i);//（值，对应索引）
        }
        return new int[0];
    }






    @Test
    public void test()
    {
        // int[] nums = {2, 3, 1, 6,0,7,4,2,1};
        // int target = 9;
        // int[] ints = tst.twoSum(nums, target);
        // System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(TwoSum(new int[]{2, 3, 1, 6,0,7,4,2,1}, 7)));
    }
}
/** 暴力解法
    public static int[] twoSum(int nums[],int target)
    {
        for (int i = 0; i< nums.length; ++i)
        {
            for(int j= i+1; j<nums.length;++j)
            {
                if(nums[i] == target - nums[j])
                    return new int [] {i,j};
            }
        }
        return new int[0];
 */