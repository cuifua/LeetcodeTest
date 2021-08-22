package com.top100.A_Array.Carrot;
import java.util.ArrayList;
import java.util.List;

/*
【题目】
    给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
    请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。

 【例题】
    输入：nums = [4,3,2,7,8,2,3,1]
    输出：[5,6]

    输入：nums = [1,1]
    输出：[2]

 【思路】
   遍历数组，将每个数字交换到它理应出现的位置上，下面情况不用换：
      当前数字本就出现在理应的位置上，跳过，不用换。
      当前数字理应出现的位置上，已经存在当前数字，跳过，不用换。
   再次遍历，如果当前位置没对应正确的数，如上图索引 4、5，则将对应的 5、6 加入 res
 */
public class DisappearNum_448
{
    List<Integer> result = new ArrayList<>();//最后装结果的
    public List<Integer> dis (int[] nums)
    {
        int i = 0;
        while( i < nums.length)
        {
            //当前数字本就出现在理应的位置上，跳过，不用换。
            if(nums[i] == i+1)
            {
                i++;
                continue;
            }
            //当前数字理应出现的位置上，已经存在当前数字，跳过，不用换。
            //当前索引的数字理应待的索引，比如nums[3]上有一个数字7，那么就看索引nums[6]有没有数字7，此时的index就是应该待的索引数
            int index = nums[i]-1;
            if(nums[i] == nums[index])
            {
                i++;
                continue;
            }

            //剩下的情况就是：将遍历到的目前的数字交换到自己该去的索引上
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }

        //再次遍历，如果当前位置没对应正确的数，如上图索引 4、5，则将对应的 5、6 加入 res
        for (int j = 0; j < nums.length; j++)
        {
            if(nums[j] != j+1)
                result.add(j+1);
        }
        return result;
    }
}



