package com.top100.B_Hash.Set;

import java.util.HashSet;
import java.util.Set;

/*
 * ����Ŀ��
 *      ���˿����������5���ƣ��ж��ǲ���һ��˳�ӣ�����5�����ǲ��������ġ�2��10Ϊ���ֱ���
 *      AΪ1��JΪ11��QΪ12��KΪ13������С��Ϊ 0 �����Կ����������֡�A ������Ϊ 14��
 * �����⡿
 *      ����: [0,0,1,2,5]
 *      ���: True
 * ��˼·��
 *      �������� 1�����鲻�ظ�
 *              2�����ֵ-��Сֵ<5
 *
 */
public class isStraight_off61
{
    public boolean isStraight(int[] nums)
    {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int min = 14;

        for(int num : nums)
        {
            if(num == 0)  continue;
            max = Math.max(max,num);
            min = Math.min(min,num);

            if(set.contains(num))
                return false;
            set.add(num);
        }
        return max-min < 5;
    }
}
