package com.top100.A_Array.TwoPoint;

import org.junit.Test;

public class MaxArea
{
    public int maxarea(int[] curr)
    {
        int left = 0, right = curr.length - 1;
        int ans = 0;

        while (left < right)
        {
            int area = Math.min(curr[left], curr[right]) * (right - left);
            ans = Math.max(ans, area);

            if (curr[left] < curr[right]) ++left;
            else --right;
        }
        return ans;
    }




    @Test
    public void test()
    {
        int[] ts = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxarea(ts));
    }
}
