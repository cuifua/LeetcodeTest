package com.top100.D_QueueStack;
import org.junit.Test;

import java.util.*;

/*
【题目】
    给定一个非空的整数数组，返回其中出现频率前k高的元素。

【例题】
    输入: nums = [1,1,1,2,2,3], k = 2
    输出: [1,2]

    输入: nums = [1], k = 1
    输出: [1]
 */
class TopKFrequent_347
{
    public static int[] topKFrequent (int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);


        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>()//降序，小顶
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
                pq.offer(m);

            else if(map.get(pq.peek()) < map.get(m))
            {
                pq.remove();
                pq.add(m);
            }
        }

        int[] res = new int[k];
        int index = 0;
        while(! pq.isEmpty())
            res[index++] = pq.poll();

        return res;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }


}





