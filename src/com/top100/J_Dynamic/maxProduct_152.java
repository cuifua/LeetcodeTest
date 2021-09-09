package com.top100.J_Dynamic;
/*
����Ŀ��
    ����һ���������� nums�������ҳ������г˻��������������飨�������������ٰ���һ�����֣��������ظ�����������Ӧ�ĳ˻���

��ʾ����
    ����: [2,3,-2,4]
    ���: 6
    ����:������ [2,3] �����˻� 6��

��ʾ����
    ����: [-2,0,-1]
    ���: 0
    ����:�������Ϊ 2, ��Ϊ [-2,-1] ���������顣

��˼·����̬�滮
    ��������ʱ���㵱ǰ���ֵ�����ϸ���
    ��imaxΪ��ǰ���ֵ����ǰ���ֵΪ imax = max(imax * nums[i], nums[i])
    ���ڴ��ڸ�������ô�ᵼ�����ı���С�ģ���С�ı����ġ���˻���Ҫά����ǰ��Сֵimin��imin = min(imin * nums[i], nums[i])
    ����������ʱ��imax��imin���н����ٽ�����һ������
    ʱ�临�Ӷȣ�O(n)
 */

public class maxProduct_152
{
    public int maxpro(int[] nums)
    {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;

        for(int num :nums)
        {
            if(num < 0)
            {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(imax*num,num);
            imin = Math.min(imin*num,num);

            max = Math.max(imax,max);
        }
        return max;
    }

}
