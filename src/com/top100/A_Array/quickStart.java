package com.top100.A_Array;

/**
 * @Author cuifua
 * @Date 2021/8/18 23:28
 * @Version 1.0
 */
public class quickStart
{
    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     * ��������������
     * @param arr int����һά���� �����������
     * @return int����һά����
     */
    public int[] MySort (int[] arr)
    {
        /*
        1���ڴ������Ԫ����ȡһ��Ԫ����Ϊ��׼(ͨ��ѡ��һ��Ԫ�أ������ѡ�񷽷��ǴӴ�����Ԫ�������ѡȡһ����Ϊ��׼)����Ϊ��׼Ԫ�أ�
        2�����������Ԫ�ؽ��з������Ȼ�׼Ԫ�ش��Ԫ�ط��������ұߣ�����С�ķ���������ߣ�
        3�����������������ظ����ϲ���ֱ������Ԫ�ض��������
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

    //1���ڴ������Ԫ����ȡһ��Ԫ����Ϊ��׼(ͨ��ѡ��һ��Ԫ�أ������ѡ�񷽷��ǴӴ�����Ԫ�������ѡȡһ����Ϊ��׼)����Ϊ��׼Ԫ��
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
