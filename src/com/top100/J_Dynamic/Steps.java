package com.top100.J_Dynamic;

import org.junit.Test;

class Steps
{
    public int steps(int n)
    {
        int yi = 0;
        int er = 0;
        int total = 1;

        for(int i = 0; i<n;i++)
        {
            yi = er;
            er =total ;
            total = yi + er ;
        }
        return total;
    }







    @Test
    public void test()
    {
        System.out.println(steps(5));
    }
}

