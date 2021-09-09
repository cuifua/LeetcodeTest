package com.top100.J_Dynamic.bagall;

import java.util.Arrays;

/*
����Ŀ��
    ����һ���������� coins ����ʾ��ͬ����Ӳ�ң��Լ�һ������ amount ����ʾ�ܽ�
    ���㲢���ؿ��Դճ��ܽ������� ���ٵ�Ӳ�Ҹ��� �����û���κ�һ��Ӳ�����������ܽ�����-1 ��
    �������Ϊÿ��Ӳ�ҵ����������޵ġ�

��˼·��
    dp[j]�����壺��������Ϊj�ı���������Ҫ����Ӳ��
    ��ʼ��dp���飺��ΪӲ�ҵ�����һ�����ᳬ��amount����amount <= 10^4��˳�ʼ������ֵΪ10001��dp[0] = 0
    ת�Ʒ��̣�dp[j] = min(dp[j], dp[j - coin] + 1)
            ��ǰ��������j������Ҫ��Ӳ�� = min( ֮ǰ��������j������Ҫ��Ӳ��, �������� j - coin ��Ҫ��Ӳ�� + 1����ǰӲ�ң�
    ����dp[amount]�����dp[amount]��ֵΪ10001û�б����˵���Ҳ���Ӳ����ϣ�����-1


��ʾ����
    ���룺coins = [1, 2, 5], amount = 11
    �����3
    ���ͣ�11 = 5 + 5 + 1

��ʾ����
    ���룺coins = [2], amount = 3
    �����-1

��ʾ����
    ���룺coins = [1], amount = 0
    �����0

��ʾ����
    ���룺coins = [1], amount = 1
    �����1

��ʾ����
    ���룺coins = [1], amount = 2
    �����2
 */
public class money_322
{
    public int coinchange(int[] coins,int amount)
    {
        int[] dp = new int[amount+1];//���� 1 2 5 ���11�����ľ���11��һ��Ǯ�������������dp����Ϊһ�����ֵ
        Arrays.fill(dp,amount+1);;

        for(int coin : coins)//������Ӳ��
        {
            for(int j = coin; j < amount + 1; j++)//�ڲ����Ŀ��ֵ
                dp[j] = Math.min(dp[j],dp[j-coin]+1);//��ǰ��������j������Ҫ��Ӳ�� = min( ֮ǰ��������j������Ҫ��Ӳ��, �������� j - coin ��Ҫ��Ӳ�� + 1����ǰӲ�ң�
        }

    return dp[amount] != 10001 ? dp[amount] : -1;
    }
}
