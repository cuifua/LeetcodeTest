package com.top100.D_QueueStack;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
����Ŀ��
    ������������ nums ������ k���뷵�������е� k ������Ԫ�ء�
    ��ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�

��ʾ����
    ����: [3,2,1,5,6,4] �� k = 2
    ���: 5
��ʾ����
    ����: [3,2,3,1,2,4,5,5,6] �� k = 4
    ���: 4
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
