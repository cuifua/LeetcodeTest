package com.top100.B_Hash.Set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/*
【题目】 给定两个数组，编写一个函数来计算它们的交集。
【例题】 输入：nums1 = [1,2,2,1], nums2 = [2,2]
        输出：[2]

        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出：[9,4]

 */
public class Intersection
{
    public int[] intersection (int[] nums1, int[] nums2)
    {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        //把nums1中的元素全部加入到集合set1中
        for (int n1 : nums1)
            set1.add(n1);

        //查看nums2中的元素是否存在集合set1中，如果存在，就加入到集合set2中
        for (int n2 : nums2)
        {
            if(set1.contains(n2))
                set2.add(n2);
        }

        //下面一大坨是把集合set2放进数组int[]
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

