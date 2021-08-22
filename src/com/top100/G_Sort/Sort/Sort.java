package com.top100.G_Sort.Sort;

/**
 * @Author cuifua
 * @Date 2021/7/20 14:44
 * @Version 1.0
 */
public abstract class Sort
{
    public abstract void sort(Integer[] nums);

    protected boolean less(Integer v, Integer w)
    {
        return v < w;
    }
    protected void swap(Integer[] a, int i, int j)
    {
        Integer temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}