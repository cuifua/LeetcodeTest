package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author cuifua
 * @Date 2021/7/20 14:38
 * @Version 1.0
 */
//==============================���������ҵ�һ���ԱȵĻ�׼����ÿ�ξͱ���ֻ�ͻ�׼���ȣ����С�ͺͻ�׼��λ�ý���
public class B_Selection extends Sort
{
    @Override
    public void sort(int[] nums)
    {
        for (int i = 0; i < nums.length - 1; i++)
        {
            int min = nums[i];//��¼��С��
            int index = i;//��¼��С���±�

            for (int j = i + 1; j < nums.length; j++)
            {
                if(nums[j] < min)//��������������������С����С
                {
                    min = nums[j];//������С������С��������Ŀǰ�����������j����
                    index = j;//��С���±�Ҳ����Ϊj
                }
            }

            if(i != index) // ���i��λ�ò�����С��,�򽻻���С��Ԫ�ص�i��λ��
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
