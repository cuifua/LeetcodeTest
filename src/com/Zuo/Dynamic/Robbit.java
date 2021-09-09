package com.Zuo.Dynamic;

/*
����Ŀ��
    �������ų�һ�е�N��λ�ã���Ϊ1~N��N һ�����ڻ���� 2
    ��ʼʱ�����������е�Mλ����(M һ���� 1~N �е�һ��)��
    �������������1λ�ã���ô��һ��ֻ����������2λ�ã�
    �������������Nλ�ã���ô��һ��ֻ���������� N-1 λ�ã�
    ��������������м�λ�ã���ô��һ�����������߻��������ߣ�
    �涨�����˱����� K ��������������Pλ��(PҲ��1~N�е�һ��)�ķ����ж����֣������ĸ����� N��M��K��P�����ط�����
��˼·��
    1   2    3   4   5   6   7    --->n��λ��
    M->        <-M->       <-M
 */
public class Robbit
{
    //1�������ݹ鷨
    public int ways1(int N, int M, int K, int P)
    {
        if(N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N)   return 0;

        return walk1(N,M,K,P);
    }

    /**
     * @param N     λ��Ϊ1~n�̶�����
     * @param cur   ��ǰ��curλ�ã��ɱ����
     * @param rest  ��ʣres��û���ߣ��ɱ����
     * @param P     P����Ŀ��λ�ã��̶�����
     * @return      ֻ����1~nλ�����ƶ�����ǰ��curλ�ã�����rest����ͣ��Pλ�õķ���
     */
    public int walk1(int N, int cur, int rest, int P)//walk(6,3,3,4)һ����6��λ�ã�������3λ���ϣ�����3�������ߣ������ߵ�4λ�ã���ʼ����6��4�ǲ����
    {                                               //��һ�������ߣ�����walk(6,2,2,4),�����ߵĻ�����walk(6,4,2,4),��ʼ�ݹ�
        /*
        ���û��ʣ�ಽ���ˣ���ǰ��curλ�þ�������λ��
        �������λ��ͣ��P�ϣ���ô֮ǰ�����ƶ�������Ч��
        �������λ��û��ͣ��P�ϣ���ô֮ǰ�����ƶ�������Ч��
       */
        if(rest == 0)
            return cur == P ? 1 : 0;

        //�������rest��Ҫ�ߣ�����ǰ��curλ����1�ϣ���ô��ǰ�ⲽֻ����2��
        //�������̾��ǣ�����2λ���ϣ���ʣrest-1��Ҫ��
        if(cur == 1)
            return walk1(N,2,rest-1,P);

        //�������rest��Ҫ�ߣ�����ǰ��curλ�������һ��λ���ϣ���ô��ǰ�ⲽֻ����N-1��
        //�������̾��ǣ�����N-1λ���ϣ���ʣrest-1��Ҫ��
        if(cur == N)
            return walk1(N,N-1,rest-1,P);

        //�������rest��Ҫ�ߣ�����ǰ��curλ����Nλ���ϣ����ڱ߽磬��������Ҳ��������,�����з������
        return walk1(N,cur+1,rest-1,P) + walk1(N,cur-1,rest-1,P);
    }


    //2�������Ż���
    public int ways1Cache(int N, int M, int K, int P)
    {
        if(N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N)   return 0;

        int[][] dp = new int[N+1][K+1];//��һ�����������е�λ�ã��ڶ���������restʣ�ಽ�������dp�����԰ѵ��µݹ�����з���ֵװ�£�dp����ŵ��ǿɱ��
        for(int row = 0; row <= N ; row++)
        {
            for(int col = 0; col <= K; col++)
            {
                dp[row][col] = -1;//��ʾĿǰ���в�����ϻ�û��ʼ����
            }
        }
        return walk1Cache(N,M,K,P,dp);
    }
    public int walk1Cache(int N, int cur, int rest, int P,int[][] dp)
    {
        if(dp[cur][rest] != -1)
            return dp[cur][rest];

        if(rest == 0)
        {
            dp[cur][rest] = cur == P ? 1 : 0;//�ȱ��ŷ��أ���д����
            return dp[cur][rest];
        }


        if(cur == 1)
        {
            dp[cur][rest] = walk1Cache(N,2,rest-1,P,dp);
            return dp[cur][rest];
        }


        if(cur == N)
        {
            dp[cur][rest] =  walk1Cache(N,N-1,rest-1,P,dp);
            return dp[cur][rest];
        }

        dp[cur][rest] = walk1Cache(N,cur+1,rest-1,P,dp) + walk1Cache(N,cur-1,rest-1,P,dp);
        return dp[cur][rest];
    }




    //3��dp�Ż���
    public static int waysDynamic(int N, int M, int K, int P)
    {
        // ������Чֱ�ӷ���0
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N)
            return 0;

        int[][] dp = new int[K + 1][N + 1];
        dp[0][P] = 1;

        for (int i = 1; i <= K; i++)
        {
            for (int j = 1; j <= N; j++) //j�ǵ�ǰλ��  i��ʣ�ಽ��
            {
                if (j == 1)
                    dp[i][j] = dp[i - 1][2];
                 else if (j == N)
                    dp[i][j] = dp[i - 1][N - 1];
                 else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];

            }
        }
        return dp[K][M];
    }
}
