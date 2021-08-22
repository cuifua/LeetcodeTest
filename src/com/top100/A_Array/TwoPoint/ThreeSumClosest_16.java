package com.top100.A_Array.TwoPoint;


import java.util.Arrays;

public class ThreeSumClosest_16
{
    public int threeSumClosest(int[] nums, int target)
    {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for(int i=0;i<nums.length;i++)
        {
            int L = i+1, R = nums.length - 1;
            while(L < R)
            {
                int temp = nums[L] + nums[R] + nums[i];
                if(Math.abs(target - temp) < Math.abs(target - ans))
                    ans = temp;
                if(temp > target)
                    R--;
                else if(temp < target)
                    L++;
                else
                    return ans;
            }
        }
        return ans;
    }
}
