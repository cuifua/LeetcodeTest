package com.top100.B_Hash.map;

import java.util.HashMap;
import java.util.Map;

/**
 * ����Ŀ��
 *      ��г������ָһ��������Ԫ�ص����ֵ����Сֵ֮��Ĳ�� ������ 1 ��
 *      ���ڣ�����һ���������� nums �����������п��ܵ����������ҵ���ĺ�г�����еĳ��ȡ�
 *      �������������һ���������������������У�������ͨ��ɾ��һЩԪ�ػ�ɾ��Ԫ�ء��Ҳ��ı�����Ԫ�ص�˳����õ�����
 * �����⡿
 *      ���룺nums = [1,3,2,2,5,2,3,7]
 *      �����5
 *      ���ͣ���ĺ�г�������� [3,2,2,2,3]
 *
 *      ���룺nums = [1,2,3,4]
 *      �����2
 *
 *      ���룺nums = [1,1,1,1]
 *      �����0
 * ��˼·�� look at the second methond
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
