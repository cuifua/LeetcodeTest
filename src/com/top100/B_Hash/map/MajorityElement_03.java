package com.top100.B_Hash.map;
/*
 * 【题目】
 *      给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 n/2 的元素。
 *      你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 【例题】
 *      输入：[3,2,3]
 *      输出：3
 *
 *      输入：[2,2,1,1,1,2,2]
 *      输出：2
 * 【思路】
 */


import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement_03
{
    public int major(int[] x)
    {
        Map<Integer,Integer> fin = new HashMap<>();
        int len = x.length;

        for(int i = 0 ; i < len; i++)
        {
            if(fin.containsKey(x[i]))
                fin.put(x[i],fin.get(x[i])+1);

            else
                fin.put(x[i],1);

            if(fin.get(x[i]) > len/2)
                return x[i];
        }
      return 0;
    }


    @Test
    public void test()
    {
        System.out.println(major(new int[] {4,2,4,5,3,4,4}));
    }
}
