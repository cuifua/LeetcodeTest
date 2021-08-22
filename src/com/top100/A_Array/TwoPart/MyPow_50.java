package com.top100.A_Array.TwoPart;

import org.junit.Test;

/*
 * 【题目】
 *      实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）
 * 【例题】
 *      输入：x = 2.00000, n = 10
 *      输出：1024.00000
 *
 *      输入：x = 2.10000, n = 3
 *      输出：9.26100
 *
 *      输入：x = 2.00000, n = -2
 *      输出：0.25000
 *      解释：2-2 = 1/22 = 1/4 = 0.25
 * 【思路】
 *      快速幂方法
 *      快速幂算法」的本质是分治算法。举个例子，如果我们要计算 x^{64}：x²---x四次方---x八次方---x十六次方---x三十二次方
 *      从 x²开始，每次直接把上一次的结果进行平方，计算 6 次就可以得到 x^{64}的值，而不需要对 x²乘 63 次。
 *
 *      当我们要计算 x^n时，我们可以先递归地计算出 y = x的（N/2）次方。
 *      根据递归计算的结果
 *          如果 n 为偶数，那么 x^n = y^2
 *          如果 n为奇数，那么 x^n = y^2 * x
*       递归的边界为 n =0，任意数的 0 次方均为 1。
 */
public class MyPow_50
{
    public double myPow(double x, int n)
    {
        long N = n;
        if(N >= 0)   return quickMul(x,N);
        else         return 1.0/quickMul(x,-N);
    }

    public double quickMul(double x, long N)

    {
        if(N == 0)   return 1.0;

        double y = quickMul(x,N/2);
        if(N % 2 == 0)    return y*y;
        else              return y*y*x;
    }

    @Test
    public void test()
    {
        System.out.println(myPow(2.0,-4));
    }
}
