package com.Zuo.Dynamic;

import org.junit.Test;

/*
����Ŀ���������ҳ���ģ�͢�
    �涨1��A��Ӧ��2��B��Ӧ��3��C��Ӧ����ôһ�������ַ������硰111���Ϳ���ת��Ϊ��AAA����AK��"KA"
    ����һ��ֻ�������ַ���ɵ��ַ��������ض�����ת�����
��˼·��
    ����һ����11111��
    ��һ��1ת��ΪA��ʣ���ĸ��Լ�ת��ȥ��
    ǰ����1ת��ΪK��ʣ�������Լ�ת��ȥ
    ǰ����1û�а취ת������Ϊֻ��26����ĸ
 */
public class Convert
{
    //1�������ݹ鷨
    public int convert(String s)
    {
        if(s == null || s.length() == 0)   return 0;
        return dfs(s.toCharArray(),0);
    }
    public int dfs(char[] str, int i)//str[0...i-1]���Ѿ�ת�����˹̶���
    {
        if(i == str.length)//i������ֹλ��
            return 1;

        //i��ӦA��2��ӦB....û��0��Ӧ����ĸ������0ֱ�ӷ���0
        if(str[i] == '0')
            return 0;

        //iû�е���ֹλ��
        // str[i]�����ַ���0��
        if(str[i] == '1')
        {
            int res = dfs(str,i + 1);//i �Լ���Ϊ�����Ĳ��֣������ж����ַ���

            if(i + 1 < str.length)
                    res += dfs(str,i+2);//(i��i+1)��Ϊ�����Ĳ��֣������ж����ַ���

            return res;
        }

        if(str[i] == '2')
        {
            int res = dfs(str,i+1);//i �Լ���Ϊ�����Ĳ��֣������ж����ַ���

            if(i + 1 < str.length && (str[i+1] >= '0' && str[i+1] <= '6'))
                res += dfs(str,i+2);

            return res;
        }

        //str[i] = '3'~'9'
        return dfs(str,i+1);
    }



    //3����̬�滮��
    public int convertDynamic(String s)
    {
        if(s == null || s.length() == 0)   return 0;

        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N+1];
        dp[N] = 1;

        for (int i = N-1; i >= 0 ; i--)
        {
            if(str[i] == '0')
                dp[i] = 0;

            if(str[i] == '1');
            {
                dp[i] = dp[i+1];
                if(i+1 < str.length)
                    dp[i] += dp[i + 2];
            }

            if(str[i] == '2')
            {
                dp[i] = dp[i+1];
                if(i + 1 < str.length && (str[i+1] >= '0' && str[i+1] <= '6'))
                    dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }
}
