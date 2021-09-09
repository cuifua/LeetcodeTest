package com.top100.B_Hash.map;
/*
 * ����Ŀ��
 *      ����һ����СΪ n �����飬�ҵ����еĶ���Ԫ�ء�����Ԫ����ָ�������г��ִ��� ���� n/2 ��Ԫ�ء�
 *      ����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�
 * �����⡿
 *      ���룺[3,2,3]
 *      �����3
 *
 *      ���룺[2,2,1,1,1,2,2]
 *      �����2
 * ��˼·��
 */


import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement_03
{
    public int major(int[] x)
    {
        Map<Integer,Integer> fin = new HashMap<>();
        int len = x.length;

        for(int i = 0 ; i < len; i++)
        {
            if(fin.containsKey(x[i]))
                fin.put(x[i],fin.get(x[i])+1);

            else
                fin.put(x[i],1);

            if(fin.get(x[i]) > len/2)
                return x[i];
        }
      return 0;
    }


    @Test
    public void test()
    {
        System.out.println(major(new int[] {4,2,4,5,3,4,4}));
    }
}
