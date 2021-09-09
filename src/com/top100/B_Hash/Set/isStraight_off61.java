package com.top100.B_Hash.Set;

import java.util.HashSet;
import java.util.Set;

/*
 * 【题目】
 *      从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
 *      A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 【例题】
 *      输入: [0,0,1,2,5]
 *      输出: True
 * 【思路】
 *      满足条件 1、数组不重复
 *              2、最大值-最小值<5
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
