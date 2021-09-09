package com.top100.A_Array.BitOperation;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashSet;

/*
 * 【题目】
 *      给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *      你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 【例题】
 *      输入: [2,2,1]
 *      输出: 1
 *
 *      输入: [4,1,2,1,2]
 *      输出: 4
 * 【思路】
 *      任何数和 00 做异或运算，结果仍然是原来的数，即 a ? 0 = a。
 *      任何数和其自身做异或运算，结果是 0，即 a ^ a = 0。
 *      异或运算满足交换律和结合律，即a ^ b ^ a = b ^ a ^ a = b ^ (a ^ a) = b ^ 0 = b。
 *      【其余数均出现两次，两个相同的数异或后变为0，而只出现一次的数异或完还是自己】
 */
public class SingleNumber_136
{
    public int singlenumber(int[] nums)
    {
        int single = 0;
        for (int num : nums)
            single ^= num;

        return single;
    }

    @Test
    public void test()
    {
        int[] x = new int[] {1,3,4,2,3,2,4};
        System.out.println(singlenumber(x));
    }
}

/**  暴力解法，时间复杂度O（n?）
 public int singlenumber (int[] x)
    {

        for(int i = 0; i < x.length; i++ )
        {
            for(int j = i+1; j < x.length; j++)
            {
                int single = x[i];
                if(x[j] - x[i] != 0)
                {
                    single = x[i];
                }
                else
                {
                    single = x[i+1];
                }
                return single;
            }
        }
        return 0;
    }
 */
/**  HashMap表   时间复杂度O(n)
class Solution
{
    public int singleNumber(int[] nums)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : nums)
         {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet())
         {
            Integer count = map.get(i);
            if (count == 1)
                return i;
        }
        return -1;
    }
}
 -------------------------------------------------Hash表  */
/**  桶排序法  时间复杂度
    public int singleNumber(int[] nums)
    {
        if (nums.length == 1)
            return nums[0];

        //排序
        Arrays.sort(nums);
        for (int i = 1; i < nums.length-1; i+=2)
        {
            if (nums[i] == nums[i-1])
            continue;
            else
            return nums[i-1];
        }
      return nums[nums.length-1];
    }
 */
/**  HashSet
class Solution
 {
    public int singleNumber(int[] nums)
    {
         if (nums.length == 1)
             return nums[0];

         HashSet<Integer> set = new HashSet<>();

         for (int x : nums)
         {
             //已经存在，则去除
             if(set.contains(x))
                 set.remove(x);

             //否则存入
             else
                 set.add(x);
         }
         //返回仅剩的一个元素
         return set.iterator().next();
    }
}
 */


