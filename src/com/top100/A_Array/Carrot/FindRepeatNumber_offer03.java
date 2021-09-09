package com.top100.A_Array.Carrot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
����Ŀ�� �ҳ��������ظ������֡�
        ��һ������Ϊ n ������ nums ����������ֶ��ڡ� 0��n-1 ���ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�
        Ҳ��֪��ÿ�������ظ��˼��Ρ����ҳ�����������һ���ظ������֡�
�����⡿
        ���룺
        [2, 3, 1, 0, 2, 5, 3]
        �����2 �� 3
 */

//��һ�ַ�������HashSet����ΪSet���������治�����ظ���ֵ������ͨ������Setֵ���ܷ���ӳɹ����ж�
public class FindRepeatNumber_offer03
{
    public int repeat(int[] nums)
    {
        if(nums.length == 0)   return -1;

        Set<Integer> set = new HashSet<>();
        for(int num : nums)
        {
            if(set.contains(num))
                return num;
            else
                set.add(num);
        }

        return -1;
    }
}

/*
�ڶ��ַ�������Ϊ��Ŀ˵��nums ����������ֶ��ڡ� 0��n-1 ���ķ�Χ�ڡ������ú��±�0-n-1һ��
�Ǿ����������ܲ���λ��һ���ܲ�һ���ӣ�ɨ�赽���ܲ������������Ӧ�ڵĿ�λ���Ѿ����ˣ����������ظ��ģ��������ֵ

public class FindRepeatNumber_offer03
{
    public int find(int[] nums)
    {
        int i = 0;
        while( i < nums.length)
        {
            if(nums[i] == i)                 //��һ��������ܲ���λ����
            {
                i++;
                continue;
            }

            int index = nums[i];
            if(nums[i] == nums[index])       //�ڶ��������ɨ�赽�����λ���ܲ��������Լ��Ŀ�λ�Ѿ�����
            {                                //���ظ����ܲ�����������ܲ�ֵ
                return nums[i];
            }

            else                             //�����������������������ų����Ǿͽ�������ɨ�赽������ܲ��ͻ��Լ��Ŀ�λȥ
            {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
            }
        }
        return -1;
    }
}
*/

