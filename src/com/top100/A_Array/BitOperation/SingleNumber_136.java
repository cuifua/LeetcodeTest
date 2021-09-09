package com.top100.A_Array.BitOperation;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashSet;

/*
 * ����Ŀ��
 *      ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
 *      ����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
 * �����⡿
 *      ����: [2,2,1]
 *      ���: 1
 *
 *      ����: [4,1,2,1,2]
 *      ���: 4
 * ��˼·��
 *      �κ����� 00 ��������㣬�����Ȼ��ԭ���������� a ? 0 = a��
 *      �κ�������������������㣬����� 0���� a ^ a = 0��
 *      ����������㽻���ɺͽ���ɣ���a ^ b ^ a = b ^ a ^ a = b ^ (a ^ a) = b ^ 0 = b��
 *      �����������������Σ�������ͬ���������Ϊ0����ֻ����һ�ε�������껹���Լ���
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

/**  �����ⷨ��ʱ�临�Ӷ�O��n?��
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
/**  HashMap��   ʱ�临�Ӷ�O(n)
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
 -------------------------------------------------Hash��  */
/**  Ͱ����  ʱ�临�Ӷ�
    public int singleNumber(int[] nums)
    {
        if (nums.length == 1)
            return nums[0];

        //����
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
             //�Ѿ����ڣ���ȥ��
             if(set.contains(x))
                 set.remove(x);

             //�������
             else
                 set.add(x);
         }
         //���ؽ�ʣ��һ��Ԫ��
         return set.iterator().next();
    }
}
 */


