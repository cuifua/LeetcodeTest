package com.top100.D_QueueStack;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
【题目】
    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

【示例】
    输入: [3,2,1,5,6,4] 和 k = 2
    输出: 5
【示例】
    输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
    输出: 4
 */
public class ArrTopK_215
{
    public int findKthLargest(int[] nums, int k)
    {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o1-o2;
            }
        });

        for(int i = 0 ; i < nums.length; i++)
        {
            if(queue.size() < k)
                queue.offer(nums[i]);
            else
            {
                if (nums[i] >= queue.peek())
                {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        return queue.peek();
    }
}
