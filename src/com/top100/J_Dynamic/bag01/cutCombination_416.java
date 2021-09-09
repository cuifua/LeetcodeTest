package com.top100.J_Dynamic.bag01;

/*
����Ŀ��
    ����һ�� ֻ���������� �� �ǿ� ����nums �������ж��Ƿ���Խ��������ָ�������Ӽ���ʹ�������Ӽ���Ԫ�غ���ȡ�

��ʾ����
    ���룺nums = [1,5,11,5]
    �����true
    ���ͣ�������Էָ�� [1, 5, 5] �� [11] ��
��ʾ����
    ���룺nums = [1,2,3,5]
    �����false
    ���ͣ����鲻�ָܷ������Ԫ�غ���ȵ��Ӽ�

��˼·��

 */
public class cutCombination_416
{
    public boolean canPartition(int[] nums)
    {
        int len = nums.length; // ��Ŀ�Ѿ�˵�ǿ����飬���Բ����ǿ��ж�
        int sum = 0;
        for (int num : nums)
            sum += num;

        if ((sum & 1) == 1)// ���У�������������Ͳ�����Ҫ��
            return false;

        int target = sum / 2;

        boolean[][] dp = new boolean[len][target + 1];// ������ά״̬���飬�У���Ʒ�������У����������� 0��


        if (nums[0] <= target)// ������� 0 �У��� 1 ����ֻ�����ݻ�Ϊ���Լ��ı���ǡ��װ��
            dp[0][nums[0]] = true;


        for (int i = 1; i < len; i++) // ��������漸��
        {
            for (int j = 0; j <= target; j++)
            {
                // ֱ�Ӵ���һ���Ȱѽ����������Ȼ��������
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j)
                {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
            }
        }
        return dp[len - 1][target];
    }
}
