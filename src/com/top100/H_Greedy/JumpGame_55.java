package com.top100.H_Greedy;

/**
 * @Author cuifua
 * @Date 2021/9/3 19:56
 * @Version 1.0
 */
/*
����Ŀ��
    ����һ���Ǹ���������nums �������λ������� ��һ���±� ��
    �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
    �ж����Ƿ��ܹ��������һ���±ꡣ

��ʾ����
    ���룺nums = [2,3,1,1,4]
    �����true
    ���ͣ��������� 1 �������±� 0 �����±� 1, Ȼ���ٴ��±� 1 �� 3 ���������һ���±ꡣ

��ʾ��2��
    ���룺nums = [3,2,1,0,4]
    �����false
    ���ͣ������������ܻᵽ���±�Ϊ 3 ��λ�á������±�������Ծ������ 0 �� ������Զ�����ܵ������һ���±ꡣ

 */
public class JumpGame_55
{
    public boolean canjump(int[] nums)
    {

        int len = nums.length;
        if(len <= 1)   return true;

        int maxStep = nums[0];
        for (int i = 1; i < len-1; i++)
        {
            if (i <= maxStep)//�����ǰλ�������λ��֮�ڣ���ʾ�ɴ�,�ڴ˻����ϲ������Լ�����λ�ú��Լ�����Ծλ����˭����һ��
                maxStep = Math.max(maxStep,nums[i]+i);
        }
        return maxStep >= len-1;
    }
}
