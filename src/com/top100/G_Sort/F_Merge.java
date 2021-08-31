package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;

/**
 * @Author cuifua
 * @Date 2021/7/20 15:00
 * @Version 1.0
 */
public class F_Merge extends Sort
{
    //�ϲ�ʱ����Ҫ�������飬�ռ临�Ӷ�Ϊ O(N)
    private Integer[] aux;

    //�鲢�������������������Ѿ�����Ĳ��ֹ鲢��һ����
    //l��Ҫ�ϲ���������ˣ�m�е㣬h��Ҫ�ϲ��������Ҷ�
    private void merge(int[] nums, int l, int m, int h)
    {
        int i = l, j = m+1;
        for(int k = l; k <= h; k++)
            aux[k] = nums[k];//�����ݸ��Ƶ���������

        for(int k = l; k <= h; k++)
        {
            if(i > m)
                nums[k] = aux[j++];
            else if(j > h)
                nums[k] = aux[i++];
            else if(aux[i]<=aux[j])
                nums[k] = aux[i++];
            else
                nums[k] = aux[j++];
        }
    }

    //��һ��������ֳ�����С����ȥ��⡣
    //��Ϊÿ�ζ�������԰�ֳ����������⣬���ֶ԰�ֵ��㷨���Ӷ�һ��Ϊ O(NlogN)��
    @Override
    public void sort(int[] nums)
    {
        aux = new Integer[nums.length];
        sort(nums, 0, nums.length-1);
    }

    private void sort(int[] nums, int l, int h)
    {
        if(h<=l)
            return;

        int mid = l + (h - l)/2;
        sort(nums, l, mid);
        sort(nums, mid+1, h);
        merge(nums, l, mid, h);
    }
}
