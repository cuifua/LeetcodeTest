package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author cuifua
 * @Date 2021/7/20 14:38
 * @Version 1.0
 */
//==============================本质是先找到一个对比的基准数，每次就遍历只和基准数比，最后小就和基准数位置交换
public class B_Selection extends Sort
{
    @Override
    public void sort(int[] nums)
    {
        for (int i = 0; i < nums.length - 1; i++)
        {
            int min = nums[i];//记录最小数
            int index = i;//记录最小数下标

            for (int j = i + 1; j < nums.length; j++)
            {
                if(nums[j] < min)//如果遍历到的这个数比最小数还小
                {
                    min = nums[j];//更新最小数，最小数现在是目前遍历到的这个j的数
                    index = j;//最小数下标也更新为j
                }
            }

            if(i != index) // 如果i的位置不是最小的,则交换最小的元素到i的位置
                swap(nums,i,index);
        }

    }



    @Test
    public void SelectTest()
    {
        int[] nums = new int[]{2,3,4,9,5,8};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
