package com.top100.A_Array;

/**
 * @Author cuifua
 * @Date 2021/8/18 23:28
 * @Version 1.0
 */
public class quickStart
{
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort (int[] arr)
    {
        /*
        1、在待排序的元素任取一个元素作为基准(通常选第一个元素，但最的选择方法是从待排序元素中随机选取一个作为基准)，称为基准元素；
        2、将待排序的元素进行分区，比基准元素大的元素放在它的右边，比其小的放在它的左边；
        3、对左右两个分区重复以上步骤直到所有元素都是有序的
        */
        quickSort(arr,0,arr.length-1);
        return arr;
    }

    public void quickSort(int[] list, int left, int right)
    {
        if(left < right)
        {
            int point = partition(list,left,right);
            quickSort(list,left,point-1);
            quickSort(list,point+1,right);
        }
    }

    //1、在待排序的元素任取一个元素作为基准(通常选第一个元素，但最的选择方法是从待排序元素中随机选取一个作为基准)，称为基准元素
    public int partition (int[] list, int left, int right)
    {
        int first = list[left];
        while(left < right)
        {
            while(left < right && list[right] >= first)
            {
                right--;
            }
            swap(list,left,right);

            while(left < right && list[left] <= first)
            {
                left ++;
            }
            swap(list,left,right);
        }
        return left;
    }

    private void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
