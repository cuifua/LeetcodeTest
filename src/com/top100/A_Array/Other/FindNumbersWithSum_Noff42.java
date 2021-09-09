package com.top100.A_Array.Other;

import java.util.ArrayList;

/*
【题目】
    输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
    如果有多对数字的和等于S，返回两个数的乘积最小的，如果无法找出这样的数字，返回一个空数组即可。
    返回值描述：
    对应每个测试案例，输出两个数，小的先输出。
【示例】
    输入：
    [1,2,4,7,11,15],15

    返回值：
    [4,11]
 */
public class FindNumbersWithSum_Noff42
{
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum)
    {
        ArrayList< Integer> list = new ArrayList<>();

        int left = 0;
        int right = array.length - 1;
        int ij = Integer.MAX_VALUE;

        while(left < right)
        {
            int sums = array[left] + array[right];
            if(sums > sum)
                right --;
            else if(sums < sum)
                left ++;
            else
            {
                if(ij > left*right)
                {
                    list.clear();
                    list.add(array[left]);
                    list.add(array[right]);
                    ij = left * right;
                }
                left ++;
            }
        }
        return list;
    }
}
