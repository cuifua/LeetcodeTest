package com.top100.G_Sort;

import com.top100.G_Sort.Sort.Sort;
import org.junit.Test;

/**
 * @Author cuifua
 * @Date 2021/7/20 15:00
 * @Version 1.0
 */
public class F_Merge
{
    public void mergeSort(int[] nums,int left, int right)// ��Ҫ�������飬�ռ临�Ӷ�Ϊ O(N)
    {
        if(left < right)
        {
            int mid = left + (right - left)/2;
            mergeSort(nums,0,mid);//����߲��ּ�����
            mergeSort(nums,mid+1,right);//���ұ߲��ּ�����

            merge(nums, left, mid, right);//�ϲ�
        }
    }

    public void merge(int[] nums,int left, int mid, int right)// ���ֿ�������ʼ����ϲ�
    {
        int i = left;      //3 4 6 8    7 4 1  ---->�����3�൱��i, 7�൱��j
        int j = mid + 1;
        int index = left;//��ʱ������±�
        int[] temp = new int[nums.length];

        while(i <= mid && j <=right)
        {
            if(nums[i] < nums[j])  //���3С��7����ô��ʱ����������ľ���nums[i]
                temp[index++] = nums[i++];

            else
                temp[index++] = nums[j++];
        }


        while(i <= mid) temp[index++] = nums[i++];//�����ߵ�û�ϲ���ȥ������3��ߵ�

        while(j <= right)  temp[index++] = nums[j++];   //����ұߵ�û�ϲ���ȥ������1�ұߵ�

        //��temp�������䵽�����ָ��λ��
        for (int m = left; m <=right; m++)
            nums[m]=temp[m];
    }





    @Test
    public void Mergetest()
    {
        int[] nums = {49, -38, 65, -97, 76, 13, 27, 50};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println("�ź�������飺");
        for (int e : nums)
            System.out.print(e + " ");
    }
}
