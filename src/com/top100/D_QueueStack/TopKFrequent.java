package com.top100.D_QueueStack;
import org.junit.Test;

import java.util.*;

/*
����Ŀ��
    ����һ���ǿյ��������飬�������г���Ƶ��ǰk�ߵ�Ԫ�ء�

�����⡿
    ����: nums = [1,1,1,2,2,3], k = 2
    ���: [1,2]

    ����: nums = [1], k = 1
    ���: [1]
 */
class TopKFrequent
{
    public int[] topKFrequent (int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);


        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer a, Integer b)
            {
                return map.get(a) - map.get(b);
            }
        });

        for(Integer m : map.keySet())
        {
            if(pq.size() < k)
                pq.add(m);

            else if(map.get(pq.peek()) < map.get(m))
            {
                pq.remove();
                pq.add(m);
            }
        }

        int[] res = new int[k];
        int i = 0;
        while(! pq.isEmpty())
        {
            res[i++] = pq.poll();
        }
        return res;
    }

    @Test
    public void test01()
    {
        System.out.println(topKFrequent(new int[] {1,1,1,2,2,3}, 2));
    }
}





