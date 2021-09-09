package com.Company.baidu;

import java.util.*;

/**
 * @Author cuifua
 * @Date 2021/9/5 15:20
 * @Version 1.0
 */
public class MainDu
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String comp = sc.nextLine();
        String my = sc.nextLine();

        Map<Character,Integer> map = new HashMap<>();
        for(char ch : my.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);

        int count = 0;
        while(! my.isEmpty())
        {
            for(char s : comp.toCharArray())
            {
                if(map.containsKey(s))
                    map.put(s,map.get(s)-1);

                else
                    break;
            }
            count++;
        }

        System.out.println(count);
        System.out.println(my.length()-(count * comp.length()));
    }

    public int[] topKFrequent(int[] nums, int k)
    {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num,map.getOrDefault(num,0)+1);

        //½µÐò£¬Ð¡¶¥¶Ñ
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer a, Integer b)
            {
                return map.get(a) - map.get(b);
            }
        });

        for (int i = 0; i < nums.length; i++)
        {
            if(queue.size() < k)
                queue.offer(nums[i]);
            else
            {
                if(map.get(queue.peek()) <= map.get(nums[i]))
                {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }

        int[] res = new int[k];
        int index = 0;
        while(! queue.isEmpty())
            res[index++] = queue.poll();

        return res;
    }
}
