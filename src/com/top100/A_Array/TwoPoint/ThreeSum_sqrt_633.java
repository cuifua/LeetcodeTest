package com.top100.A_Array.TwoPoint;

/*
 * 【题目】
 *      给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * 【例题】
 *      输入：c = 5
 *      输出：true
 *      解释：1 * 1 + 2 * 2 = 5
 *
 *      输入：c = 3
 *      输出：false
 *
 *      输入：c = 2
 *      输出：true
 * 【思路】
 *
 */
public class ThreeSum_sqrt_633
{
    public boolean judgeSquareSum(int c)
    {
        int a = 0;
        int b =(int) Math.sqrt(c);

        while(a <= b)
        {
            int result = a*a + b*b;
            if(result == c)    return true;
            else if(result < c)    a++;
            else if(result > c)    b--;
        }
        return false;
    }
}
