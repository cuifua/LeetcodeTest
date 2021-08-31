package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author cuifua
 * @Date 2021/7/20 14:46
 * @Version 1.0
 */
//==============================本质就是每一次后一个数和前一个比较，大的放最后
public class A_Bubble extends Sort
{
    @Override
    public void sort(int[] nums)
    {
        boolean flag = true;//这里是优化，如果无顺序就是false,再走循环，否则就直接返回
        for (int i = 0; i < nums.length - 1; i++) //如果有五个数，就冒泡四次，因为每一次冒泡可以确定最后一个数字是最大数，到了最后一次冒泡，就剩最后一个了不用再比较了
        {
            //减去i的意思是每次排好后，后面已经排好的就不用管了，比如5个数1 3 4 2 5，第一次最后的5确定，第二次4确定，第三次的时候只用比较前三个数1 3 2 里找最大值
            for (int j = 0; j < nums.length - 1 - i; j++)//例如i = 2表示第三次，j < num.length(5) - 1 - 2 = 2; 【j = 0, j< 2】三个数比较两次
            {
                if(nums[j] > nums[j +1])
                {
                    flag = false;
                    swap(nums,j,j+1);
                }

                if(flag)
                    break;

            }
        }
    }


    @Test
    public void BubbleTest()
    {
        int[] num = new int[]{1,3,4,2,5,8};
        sort(num);
        System.out.println(Arrays.toString(num));
    }
}