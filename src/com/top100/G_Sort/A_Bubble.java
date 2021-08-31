package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author cuifua
 * @Date 2021/7/20 14:46
 * @Version 1.0
 */
//==============================���ʾ���ÿһ�κ�һ������ǰһ���Ƚϣ���ķ����
public class A_Bubble extends Sort
{
    @Override
    public void sort(int[] nums)
    {
        boolean flag = true;//�������Ż��������˳�����false,����ѭ���������ֱ�ӷ���
        for (int i = 0; i < nums.length - 1; i++) //��������������ð���ĴΣ���Ϊÿһ��ð�ݿ���ȷ�����һ����������������������һ��ð�ݣ���ʣ���һ���˲����ٱȽ���
        {
            //��ȥi����˼��ÿ���źú󣬺����Ѿ��źõľͲ��ù��ˣ�����5����1 3 4 2 5����һ������5ȷ�����ڶ���4ȷ���������ε�ʱ��ֻ�ñȽ�ǰ������1 3 2 �������ֵ
            for (int j = 0; j < nums.length - 1 - i; j++)//����i = 2��ʾ�����Σ�j < num.length(5) - 1 - 2 = 2; ��j = 0, j< 2���������Ƚ�����
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