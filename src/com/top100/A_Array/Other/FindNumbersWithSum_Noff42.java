package com.top100.A_Array.Other;

import java.util.ArrayList;

/*
����Ŀ��
    ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S��
    ����ж�����ֵĺ͵���S�������������ĳ˻���С�ģ�����޷��ҳ����������֣�����һ�������鼴�ɡ�
    ����ֵ������
    ��Ӧÿ�����԰����������������С���������
��ʾ����
    ���룺
    [1,2,4,7,11,15],15

    ����ֵ��
    [4,11]
 */
public class FindNumbersWithSum_Noff42
{
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum)
    {
        ArrayList< Integer> list = new ArrayList<>();

        int left = 0;
        int right = array.length - 1;
        int ij = Integer.MAX_VALUE;

        while(left < right)
        {
            int sums = array[left] + array[right];
            if(sums > sum)
                right --;
            else if(sums < sum)
                left ++;
            else
            {
                if(ij > left*right)
                {
                    list.clear();
                    list.add(array[left]);
                    list.add(array[right]);
                    ij = left * right;
                }
                left ++;
            }
        }
        return list;
    }
}
