package com.Company.Meituan;

/**
 * @Author cuifua
 * @Date 2021/9/2 16:47
 * @Version 1.0
 */
/*
С����С�����ڹ�˾��ʳ����N�Ų����������Ұڳ�һ�ţ�ÿ�Ų�����2�Ų��ι�����2���òͣ���˾ְԱ�Ŷӽ���ʳ���ò͡�
С������ְԱ�ò͵�һ�����ɲ�����С�ţ�
����ְԱ����ʳ��ʱ����������ѡ���Ѿ�����1�˵Ĳ����òͣ�ֻ�е�ÿ�Ų���Ҫô����Ҫô����2��ʱ�����Żῼ�ǿ��ŵĲ�����
��ŮְԱ����ʳ��ʱ����������ѡ��δ���˵Ĳ����òͣ�ֻ�е�ÿ�Ų�������������1��ʱ�����Żῼ���Ѿ�����1�˵Ĳ�����

������Ů�����ж��Ų�����ְԱѡ��ʱ������ѡ�����Ĳ����ò͡�
����ʳ�����������������òͣ�����M�������Ŷӽ���ʳ�ã�С�Ż����С���������Ĺ���Ԥ���Ŷӵ�ÿ���˷ֱ�������Ų�����


��������:
��һ������һ������T��1<=T<=10������ʾ����������
ÿ������ռ���У���һ������һ������N��1<=N<=500000����
�ڶ�������һ������ΪN�ҽ���������0��1��2���ַ�������i�����ֱ�ʾ�����i�Ų��������е��ò�������
����������һ������M��1<=M<=2N�ұ�֤�Ŷӵ�ÿ���˽���ʳ��ʱ���пɹ�ѡ��Ĳ�������
����������һ������ΪM�ҽ�������ĸM��F���ַ���������i����ĸΪM�������ڵ�i����Ϊ���ԣ�������ΪŮ�ԡ�


�������:
ÿ���������ռM�У���i�����һ������j��1<=j<=N������ʾ���ڵ�i���˽�ѡ�������j�Ų����ò͡�


��������1:
1
5
01102
6
MFMMFF

�������1:
2
1
1
3
4
4
 */

/*
ʹ������С���ѣ��ֱ�洢��ǰ����Ϊ0,1,2���������ӵ����ţ���Ϊpq0,pq1,pq2

����ְԱΪ����
�ȳ���������Ϊ1�����ӣ������������ͱ����2���ȼ��ڣ���pq1�ĶѶ�������ͬʱ����pq2
���û������Ϊ1�������ˣ��ȼ���pq1Ϊ�գ���ȥ������Ϊ0�����ӣ��ȼ��ڣ���pq0�ĶѶ�������ͬʱ����pq1
��Ϊ���Ŵ洢�����ȶ��У����ԶѶ�������������С�ģ���֤ÿ�����ж��ѡ��ʱ����������ߵ����ӡ�

ŮְԱͬ��
ʱ�临�Ӷȣ�O(MLogN)
���������BufferedReader��BufferedWriter���ܹ�����System.out.println�ᳬʱ��
 */
import java.io.*;
import java.util.*;

public class Main_3
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++)
        {
            int N = Integer.parseInt(reader.readLine());
            String tables = reader.readLine();
            int M = Integer.parseInt(reader.readLine());
            String enters = reader.readLine();

            int[] res = solve(tables, enters);
            for (int r : res)
            {
                writer.write(Integer.toString(r));
                writer.newLine();
            }
        }
        writer.flush();
    }

    private static int[] solve(String tables, String enters)
    {
        List<PriorityQueue<Integer>> pqs = new ArrayList<>(3);
        pqs.add(new PriorityQueue<>());
        pqs.add(new PriorityQueue<>());
        pqs.add(new PriorityQueue<>());

        for (int i = 0; i < tables.length(); i++)
            pqs.get(tables.charAt(i) - '0').add(i);

        int[] res = new int[enters.length()];
        for (int i = 0; i < enters.length(); i++)
        {
            int table;
            if (enters.charAt(i) == 'M')
            {
                if (pqs.get(1).isEmpty()) {
                    table = pqs.get(0).poll();
                    pqs.get(1).add(table);
                } else {
                    table = pqs.get(1).poll();
                    pqs.get(2).add(table);
                }
            }
            else {
                if (!pqs.get(0).isEmpty()) {
                    table = pqs.get(0).poll();
                    pqs.get(1).add(table);
                } else {
                    table = pqs.get(1).poll();
                    pqs.get(2).add(table);
                }
            }
            res[i] = table + 1;
        }

        return res;
    }

}