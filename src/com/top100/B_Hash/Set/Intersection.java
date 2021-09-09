package com.top100.B_Hash.Set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/*
����Ŀ�� �����������飬��дһ���������������ǵĽ�����
�����⡿ ���룺nums1 = [1,2,2,1], nums2 = [2,2]
        �����[2]

        ���룺nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        �����[9,4]

 */
public class Intersection
{
    public int[] intersection (int[] nums1, int[] nums2)
    {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        //��nums1�е�Ԫ��ȫ�����뵽����set1��
        for (int n1 : nums1)
            set1.add(n1);

        //�鿴nums2�е�Ԫ���Ƿ���ڼ���set1�У�������ڣ��ͼ��뵽����set2��
        for (int n2 : nums2)
        {
            if(set1.contains(n2))
                set2.add(n2);
        }

        //����һ�����ǰѼ���set2�Ž�����int[]
        int i = 0;
        int[] res = new int[set2.size()];

        for (Integer num : set2)
            res[i++] = num;

        return res;
    }



    @Test
    public void test()
    {
        int[] nums1 = {1,3,5};
        int[] nums2 = {1,3,5,9,0};
        System.out.println(intersection(nums1,nums2));
    }
}

