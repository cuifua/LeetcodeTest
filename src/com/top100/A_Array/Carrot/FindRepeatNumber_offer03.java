package com.top100.A_Array.Carrot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
【题目】 找出数组中重复的数字。
        在一个长度为 n 的数组 nums 里的所有数字都在【 0～n-1 】的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
        也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
【例题】
        输入：
        [2, 3, 1, 0, 2, 5, 3]
        输出：2 或 3
 */

//第一种方法，用HashSet，因为Set特性是里面不能有重复的值，可以通过加入Set值看能否添加成功来判断
public class FindRepeatNumber_offer03
{
    public int repeat(int[] nums)
    {
        if(nums.length == 0)   return -1;

        Set<Integer> set = new HashSet<>();
        for(int num : nums)
        {
            if(set.contains(num))
                return num;
            else
                set.add(num);
        }

        return -1;
    }
}

/*
第二种方法，因为题目说“nums 里的所有数字都在【 0～n-1 】的范围内”，正好和下标0-n-1一致
那就类似于找萝卜坑位，一个萝卜一个坑，扫描到的萝卜数字如果在它应在的坑位上已经有了，那他就是重复的，返回这个值

public class FindRepeatNumber_offer03
{
    public int find(int[] nums)
    {
        int i = 0;
        while( i < nums.length)
        {
            if(nums[i] == i)                 //第一种情况，萝卜坑位对齐
            {
                i++;
                continue;
            }

            int index = nums[i];
            if(nums[i] == nums[index])       //第二种情况，扫描到这个坑位的萝卜在属于自己的坑位已经有了
            {                                //是重复的萝卜，返回这个萝卜值
                return nums[i];
            }

            else                             //第三种情况，以上两种情况排除，那就交换，把扫描到的这个萝卜送回自己的坑位去
            {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
            }
        }
        return -1;
    }
}
*/

