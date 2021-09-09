package com.top100.A_Array.Other;

/*
����Ŀ��
    ����һ����������nums ������������ �����±� ��
    ���� �����±� �������һ���±꣬���������Ԫ����ӵĺ͵����Ҳ�����Ԫ����ӵĺ͡�
    ��������±�λ����������ˣ���ô�����֮����Ϊ 0 ����Ϊ���±����಻����Ԫ�ء���һ����������±�λ���������Ҷ�ͬ�����á�
    ��������ж�������±꣬Ӧ�÷��� ������ ����һ����������鲻���������±꣬���� -1 ��

��ʾ����
    ���룺nums = [1, 7, 3, 6, 5, 6]
    �����3
    ���ͣ�
    �����±��� 3 ��
    �����֮�� sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ��
    �Ҳ���֮�� sum = nums[4] + nums[5] = 5 + 6 = 11 ��������ȡ�

 */
public class MidIndex_724
{
    public int pivotIndex(int[] nums)
    {
        int sum = 0;
        for(int n : nums)
            sum += n;   //�����������

        int leftSum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(leftSum == sum - nums[i] - leftSum)//sum = leftSum + nums[i] + rightSum   ������ĿrightSum = leftSum
                return i;

            leftSum += nums[i];
        }

        return -1;
    }
}
