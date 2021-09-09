package com.top100.J_Dynamic;

import org.junit.Test;

/*
����Ŀ��
    ��һ�����飬������ÿ��Ա�����꿧������ʱ��
    a ���Ȼ�ϴ����ʱ��
    b ���ȱ��Ӳ����뿧�Ȼ�ϴ���Ծ���ʱ��
    �����ʱ�����б��Ӹɾ�
 */
public class DrinkCoffee
{
    public int Mintime(int[] arr,int a, int b)
    {
        return dfs(arr,a,b,0,0);
    }

    /**
     *
     * @param drinks  ���̶�������  ÿһ��Ա�����꿧�ȵ�ʱ��
     * @param a       ���̶�������  ���Ȼ�ϴһ�����ӵ�ʱ��
     * @param b       ���̶�������  �����Ծ���ʱ��
     * @param index   drinks[0...index-1]���Ѿ��ɾ��ˡ������������
     * @param washLine  ���Ȼ�����ϴ���ӵĿ���ʱ�䣬��ʱ����
     * @return
     */
    public int dfs(int[] drinks, int a, int b, int index, int washLine)
    {
        if(index == drinks.length - 1)
            return Math.min( Math.max(washLine,drinks[index]) + a, drinks[index] + b);
                            //���ӿ�����ϴ���ӵ�ʱ���Ա���ź����ʱ������ֵ�����ӿ��п���û���꣬�����ã����Ⱥ������û�ղ���

        //�ÿ��Ȼ�
        int wash = Math.max(washLine,drinks[index]) + a;//ϴindex��һ����������ʱ���
        int next1 = dfs(drinks,a,b,index+1,wash);//index+1����ϴ�ɾ����б��ӵ�ʱ��
        int p1 = Math.max(wash,next1);//���Լ�ϴ�������汭��ϴ��ȡ���ֵ����Ϊ��ϴ���˺��滹ûϴ��

        //���Ծ�
        int dry = drinks[index] + b;
        int next2 = dfs(drinks,a,b,index+1,washLine);
        int p2 = Math.max(dry,next2);

        return Math.max(p1,p2);
    }


    public int dfsDynamic(int[] drinks, int a, int b)
    {
        if(a >= b)
            return drinks[drinks.length-1] + b;


        int N = drinks.length;
        int limit = 0;//���Ȼ�ʲôʱ�����
        for(int i = 0; i < N; i++)//���������б��Ӻ����ʱ��
            limit = Math.max(limit,drinks[i] + a);

        int[][] dp = new int[N][limit+1];
         for(int washLine = 0; washLine <= limit; washLine++)//N-1������ֵ[basecase]
             dp[N-1][washLine] = Math.min(Math.max(washLine,drinks[N-1]) + a, drinks[N-1] + b);

        for (int index = N-2; index >= 0 ; index--)
        {
            for (int washLine = 0; washLine <= limit ; washLine++)
            {
                int p1 = Integer.MAX_VALUE;
                int wash = Math.max(washLine,drinks[index]) + a;//ϴindex��һ����������ʱ���
                if(wash <= limit)
                    p1 = Math.max(wash,dp[index+1][wash]);

                int p2 = Math.max(drinks[index] + b,dp[index+1][washLine]);

                dp[index][washLine] =  Math.min(p1,p2);
            }
        }



        return dp[0][0];//�����ݹ�ı��ʽд��ɶ�ͷ���ɶ
    }






    @Test
    public void test()
    {
        int[] arr = {1,1,5,5,7,10,12,12,12,12,12,12,15};
        int a = 3;
        int b = 10;
        System.out.println(Mintime(arr,a,b));
        System.out.println(dfs(arr,a,b,0,0));
    }
}
