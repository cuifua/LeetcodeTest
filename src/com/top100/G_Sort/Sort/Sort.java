package com.top100.G_Sort.Sort;

/**
 * @Author cuifua
 * @Date 2021/7/20 14:44
 * @Version 1.0
 */
public abstract class Sort
{
    public abstract void sort(int[] nums);

    protected boolean less(int v, int w)
    {
        return v < w;
    }
    protected void swap(int[] a, int i, int j)
    {
        Integer temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}