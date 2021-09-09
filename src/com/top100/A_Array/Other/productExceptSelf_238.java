package com.top100.A_Array.Other;

/*
����Ŀ��
    ����һ������Ϊn����������nums������n > 1�������������output������ output[i]����nums�г�nums[i]֮�������Ԫ�صĳ˻���

��ʾ����
    ����: [1,2,3,4]
    ���: [24,12,8,6]

��˼·��
    ԭ���飺       [1       2       3       4]
    �󲿷ֵĳ˻���   1       1      1*2    1*2*3
    �Ҳ��ֵĳ˻��� 2*3*4    3*4      4      1
    �����        1*2*3*4  1*3*4   1*2*4  1*2*3*1


��ʾ����Ŀ���ݱ�֤����֮������Ԫ�ص�ȫ��ǰ׺Ԫ�غͺ�׺���������������飩�ĳ˻����� 32 λ������Χ�ڡ�
˵��: �벻Ҫʹ�ó���������O(n) ʱ�临�Ӷ�����ɴ��⡣
 */
public class productExceptSelf_238
{
    public int[] productExceptSelf(int[] nums)
    {
        int len = nums.length;

        int[] L = new int[len];
        int[] R = new int[len];
        int[] ans = new int[len];

        L[0] = 1;
        for(int i = 1; i < len; i++)
            L[i] = nums[i-1] * L[i-1];

        R[len-1] = 1;
        for(int i = len-2; i >= 0; i--)
            R[i] = nums[i+1] * R[i+1];

        for(int i = 0; i < len; i++)
            ans[i] = L[i] * R[i];

        return ans;
    }
}
