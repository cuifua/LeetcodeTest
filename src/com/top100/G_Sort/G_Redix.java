package com.top100.G_Sort;

import org.junit.Test;

import java.util.Arrays;

/*
基数排序的说明:
(1)基数排序是对传统桶排序的扩展，速度很快。
(2)基数排序是经典的空间换时间的方式，占用内存很大, 当对海量数据排序 时，容易造成 OutOfMemoryError 。
(3)基数排序是稳定的。（注:假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，这些记录的相对次序保持不变，
    如原始数组为{1,3,2,3,5}经过排序后为{1,2,3,3,5},此时第一个3经过排序后仍然在第二个三的前面，则称这种排序算法是稳定的；否则称为不稳定的）
(4)有负数的数组，我们不用基数排序来进行排序。
 */

//====================本质就是按照位数， 先比较所有待排数字个位，个位是数字几就放进几号序列的桶，再将这次排好的按照十位排，排好后按照百位....
public class G_Redix
{
    public void redix(int[] nums)
    {
        int[][] bucket = new int[10][nums.length];
        int[] bucketElementCounts = new int[10];//每个桶的元素个数

        //求出待排数组里最大的那个数，因为只有知道最大的那个数，我们才知道最大的数是几位，如果是千位我们就循环四次，百位三次，以此类推
        int max = nums[0];
        for(int i = 1; i < nums.length; i++)
            max = Math.max(max,nums[i]);

        int maxBit = (max + "").length();//小技巧：给int加上“”变成字符串，利用字符串的.length()方法，求出一共几位
        for (int i = 0; i < maxBit; i++)
        {
            for (int j = 0; j < nums.length; j++)
            {
                int value = nums[j] / (int)Math.pow(10,i) % 10;//求的是桶的编号，比如48，算出来为4
                bucket[value][bucketElementCounts[value]] = nums[j];//bucket[4号桶][4号桶第value个数]
                bucketElementCounts[value]++;
            }

            int index = 0;
            for(int k =0; k < bucketElementCounts.length; k++)//遍历每个桶
            {
                if(bucketElementCounts[k] != 0)//假使这个桶里有数字，才能往下操作
                {
                    for(int x = 0; x < bucketElementCounts[k]; x++)//遍历每个桶的元素
                        nums[index++] = bucket[k][x];
                }
                bucketElementCounts[k] = 0;//清空桶
            }
        }
    }


    @Test
    public void RedixTest()
    {
        int[] num = {49, 3, 65, 897, 76, 13, 27, 50};
        redix(num);
        System.out.println("排好序的数组：" + Arrays.toString(num));
    }
}
