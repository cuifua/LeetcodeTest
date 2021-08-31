package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author cuifua
 * @Date 2021/7/20 14:55
 * @Version 1.0
 */
//==============================�����ǺͲ�������һ��ԭ�������������˲��������粽��Ϊ3����ô[1 3 4 2 7 9 4] 1��2��3��7��4��9
public class D_Shell extends Sort
{
    @Override
    public void sort(int[] nums)
    {
        for(int gap = nums.length/2; gap >0; gap /= 2)
        {
            for (int i = gap; i < nums.length; i++)//����ֻ���˲����������i = 1���൱�ڲ���������ǲ���Ϊ1
            {
                int insertIndex = i;
                int insertValue = nums[i];

                while(insertIndex - gap >= 0 && insertValue < nums[insertIndex - gap])
                {
                    nums[insertIndex] = nums[insertIndex-gap];
                    insertIndex -= gap;
                }
                nums[insertIndex] = insertValue;
            }
        }
    }


    @Test
    public void InsertTest()
    {
        int[] nums = new int[]{1,9,0,2,3,8,7};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
