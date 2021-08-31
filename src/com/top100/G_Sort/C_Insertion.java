package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author cuifua
 * @Date 2021/7/20 14:51
 * @Version 1.0
 */
//==============================本质就是遍历一个数字就去判断插入的位置
public class C_Insertion extends Sort
{
    @Override
    public void sort(int[] nums)
    {
        for(int i = 1; i < nums.length; i++)//插入排序得从1开始，（0的话插不了前面）为什么不是冒泡选择里的i<n-1,因为虽然是从1开始，但还是和索引[0][2][3][4]比较，还是要比较四次
        {
            int insertIndex = i;
            int insertValue = nums[i];

            //这里的insertIndex - 1 >= 0意思是保证前面要毕竟的这个索引得存在，存在才能进行比较
            while(insertIndex - 1 >= 0 && insertValue < nums[insertIndex-1])//目前遍历到的数和前一个索引指代的数比较
            {
                nums[insertIndex] = nums[insertIndex - 1];
                insertIndex --;
            }

            nums[insertIndex] = insertValue;
        }
    }


    @Test
    public void InsertTest()
    {
        int[] nums = new int[]{1,2,9,2,5,8,1,4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}