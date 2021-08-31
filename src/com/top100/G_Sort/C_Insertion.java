package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author cuifua
 * @Date 2021/7/20 14:51
 * @Version 1.0
 */
//==============================���ʾ��Ǳ���һ�����־�ȥ�жϲ����λ��
public class C_Insertion extends Sort
{
    @Override
    public void sort(int[] nums)
    {
        for(int i = 1; i < nums.length; i++)//��������ô�1��ʼ����0�Ļ��岻��ǰ�棩Ϊʲô����ð��ѡ�����i<n-1,��Ϊ��Ȼ�Ǵ�1��ʼ�������Ǻ�����[0][2][3][4]�Ƚϣ�����Ҫ�Ƚ��Ĵ�
        {
            int insertIndex = i;
            int insertValue = nums[i];

            //�����insertIndex - 1 >= 0��˼�Ǳ�֤ǰ��Ҫ�Ͼ�����������ô��ڣ����ڲ��ܽ��бȽ�
            while(insertIndex - 1 >= 0 && insertValue < nums[insertIndex-1])//Ŀǰ������������ǰһ������ָ�������Ƚ�
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