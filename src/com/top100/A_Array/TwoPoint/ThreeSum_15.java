package com.top100.A_Array.TwoPoint;
/*
����Ŀ��
    ����һ������ n ������������nums���ж�nums���Ƿ��������Ԫ�� a��b��c ��
    ʹ��a + b + c = 0 �������ҳ����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
�����⡿
    ���룺nums = [-1,0,1,2,-1,-4]
    �����[[-1,-1,2],[-1,0,1]]
��˼·��
    1.���У��������鳤�� n���������Ϊ null �������鳤��С�� 3������ []��
    2.�������������
    3.������������飺
         �� nums[i]>0����Ϊ�Ѿ�����ã����Ժ��治�������������Ӻ͵��� 0��ֱ�ӷ��ؽ����
         �����ظ�Ԫ�أ���������������ظ���
         ����ָ�� L=i+1����ָ�� R=nums.length-1,�� L<R ʱ��ִ��ѭ����
         �� nums[i]+nums[L]+nums[R]==0��ִ��ѭ�����ж������ҽ��Ƿ����һλ���ظ���ȥ���ظ��⡣��ͬʱ�� L,RL,R �Ƶ���һλ�ã�Ѱ���µĽ�
         ���ʹ��� 0��˵�� nums[R]̫��R ����
         ����С�� 0��˵�� nums[L]̫С��L ����
 */

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15
{
    public List<List<Integer>> threesum(int[] nums)
    {
        List<List<Integer>> fins = new ArrayList<>();
        Arrays.sort(nums);                                 //���������򣬴�С����

        for (int i = 0; i < nums.length; ++i)
        {
            if(nums[i] > 0)  return fins;                  //�� nums[i]>0����Ϊ�Ѿ�����ã����Ժ��治�������������Ӻ͵��� 0��ֱ�ӷ��ؽ����
            if(i > 0 && nums[i] == nums[i-1])  continue;   //�����ظ�Ԫ�أ���������������ظ���


            int L = i+1, R = nums.length - 1;  //i��0������ʼ��L��1������ʼ��R���������һ����ʼ
            while (L < R)
            {
                int temp = nums[i] + nums[L] + nums[R];
                if(temp == 0)
                {
                    List<Integer> fin = new ArrayList<>();
                    fin.add(nums[i]);
                    fin.add(nums[L]);
                    fin.add(nums[R]);
                    fins.add(fin);
                    while(L < R && nums[L] == nums[L + 1])  ++L;  //ȥ��
                    while(L < R && nums[R - 1] == nums[R])  --R;  //ȥ��

                    ++ L;
                    -- R;
                }
                else if(temp < 0)    ++L;
                else if(temp > 0)    --R;
            }
        }
        return fins;
    }



    @Test
    public void test()
    {
        int[] ts = {-1,0,1,2,-1,-4};
        System.out.println(threesum(ts));
    }
}

