package com.top100.A_Array.MoveWindows;

import org.junit.Test;
/*��7.3��
����Ŀ������һ������n���������������һ�������� target ��
       �ҳ���������������� �� target �ĳ�����С�� ����������[numsl, numsl+1, ..., numsr-1, numsr] ��
       �������䳤�ȡ���������ڷ��������������飬���� 0 ��
�����⡿
        ʾ�� 1��
        ���룺target = 7, nums = [2,3,1,2,4,3]
        �����2
        ���ͣ�������[4,3]�Ǹ������µĳ�����С�������顣

        ʾ�� 2��
        ���룺target = 4, nums = [1,4,4]
        �����1

        ʾ�� 3��
        ���룺target = 11, nums = [1,1,1,1,1,1,1,1]
        �����0
 */
class minSubArrayLen_209
{
    public int minlen(int[] nums,int target)
    {
        int left = 0;              //�������ڵ��󴰿�
        int right = 0;             //�������ڵ��Ҵ���
        int res = nums.length+1;   //���յĽ��
        int len = 0;               //��¼һ��������ĳ���
        int sum = 0;               //�����ڵ�����֮��

        while(right < nums.length)  //��������[left,right)
        {
            sum += nums[right];     //���´���״̬
            right ++;
            while (sum >= target)
            {
                len = right - left;
                res = Math.min(res,len);
                sum -= nums[left];   //�󴰿ڵ����ֳ�ȥ
                left ++;             //�����������ұ��ƶ�
            }
        }
        return res == nums.length+1 ? 0 : res;
    }
}
