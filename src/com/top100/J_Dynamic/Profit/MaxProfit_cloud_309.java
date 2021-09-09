package com.top100.J_Dynamic.Profit;

/*
����Ŀ��
    ����һ���������飬���е�i��Ԫ�ش����˵�i��Ĺ�Ʊ�۸�
    ���һ���㷨����������������������Լ�������£�����Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ��:

    �㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
    ������Ʊ�����޷��ڵڶ��������Ʊ (���䶳��Ϊ 1 ��)��
�����ӡ�
    ����: [1,2,3,0,2]
    ���: 3
    ����: ��Ӧ�Ľ���״̬Ϊ: [����, ����, �䶳��, ����, ����]
��˼·��
    ��Ϊ����������Ʊʵ����Ҳ�����ڡ������С���״̬
    ��ô��i����������У�������������С�����������״̬��
        1.�����Ͳ����У�ָ������Ϊ���������˲Ų����еģ�
        2.��i����Ϊ�����˹�Ʊ�ű�ò�����

    �����й�Ʊ����ֻ��һ��״̬
    ���Զ���ÿһ��i�����п���������״̬��
    0.���ֹ��ҵ���û����,�������������dp[i][0];
    1.�ֹ�,�������������dp[i][1]��
    2.���ֹ��ҵ��������ˣ��������������dp[i][2]��

    ��ʼ����
    dp[0][0]=0;             //�����Ͳ����У�ɶҲû��
    dp[0][1]=-1*prices[0];  //��0��ֻ����
    dp[0][2]=0;             //��������ɵ�0����������������ô��0����ǡ����ֹ��ҵ��������ˡ����״̬�ˣ�������Ϊ0�����Գ�ʼ��Ϊ0�Ǻ�����

    ��ͷϷ��
    һ����i�첻�ֹ���û������״̬dp[i][0]��Ҳ������û�й�Ʊ�����һ�������Ϊ����������û�еģ��ǻ��仰˵�Ǵ�i-1�쵽��i��ת��ʱ����ѹ����û���ҹ�Ʊ��
    ����i-1��һ��Ҳ�ǲ����У��Ǿ��ǲ����е����ֿ��ܣ�i-1�첻�ֹ��ҵ���û������dp[i-1][0]��i-1�첻�ֹɵ��ǵ�������ȥ��dp[i-1][2]��
    ���ԣ� dp[i][0]=max(dp[i-1][0],dp[i-1][2])

    ������i��ֹ�dp[i][1]�������ҳֹɣ��������ֿ��ܣ�
    1��Ҫô�������Ҿͳֹɣ�����̳�����ģ�Ҳ����dp[i-1][1]�����ֿ��ܺܺ����⣻
    2��Ҫô���������Ҳ��ֹɣ�����������ģ���ǰ����������һ��û������Ϊ������������ˣ���ô�����Ҳ��ܽ��ף�Ҳ������Ŀ����ν���䶳�ڡ��ĺ��壬
            ֻ�������ǡ����ֹ��ҵ���û���������״̬���ҽ���������룡������dp[i-1][0]-p[i]
    ���ԣ� dp[i][1]=max(dp[i-1][1],dp[i-1][0]-p[i])

    ����i�첻�ֹ��ҵ��������ˣ����־ͼ��ˣ��Ǿ���˵������һ���ǳֹɵģ�Ҫ��Ȼ�ҽ�����ʲô������
        ���ֹ�ֻ��һ��״̬������ֹɵ�������Ͻ��������õ��������棬����dp[i-1][1]+p[i]��
    ���ԣ�dp[i][2]=dp[i-1][1]+p[i]

    �ܽ᣺���һ���������������ֿ��ܣ�����һ���ǡ������С�״̬�µ����ֿ��ܣ��������֡������С��Ƚ�һ�´�С�����ؼ���
 */
public class MaxProfit_cloud_309
{
    public int maxProfit(int[] prices)
    {
        int n=prices.length;
        if(n<=1) return 0;

        int [][] dp=new int[n][3];//����״̬
        dp[0][0] = 0;//�����Ͳ����У�ɶҲû��
        dp[0][1] = -1*prices[0]; //��0��ֻ����
        dp[0][2] = 0;//��0����������������ô��0����ǡ����ֹ��ҵ��������ˡ����״̬�ˣ�������Ϊ0�����Գ�ʼ��Ϊ0�Ǻ�����

        for(int i = 1; i<n; i++)//��[1]...[n-1]
        {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]=dp[i-1][1]+prices[i];

        }
        return Math.max(dp[n-1][0],dp[n-1][2]);
    }
}