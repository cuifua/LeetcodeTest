package com.Company.Meituan;

/**
 * @Author cuifua
 * @Date 2021/9/2 16:47
 * @Version 1.0
 */
/*
小美和小团所在公司的食堂有N张餐桌，从左到右摆成一排，每张餐桌有2张餐椅供至多2人用餐，公司职员排队进入食堂用餐。
小美发现职员用餐的一个规律并告诉小团：
当男职员进入食堂时，他会优先选择已经坐有1人的餐桌用餐，只有当每张餐桌要么空着要么坐满2人时，他才会考虑空着的餐桌；
当女职员进入食堂时，她会优先选择未坐人的餐桌用餐，只有当每张餐桌都坐有至少1人时，她才会考虑已经坐有1人的餐桌；

无论男女，当有多张餐桌供职员选择时，他会选择最靠左的餐桌用餐。
现在食堂内已有若干人在用餐，另外M个人正排队进入食堂，小团会根据小美告诉他的规律预测排队的每个人分别会坐哪张餐桌。


输入描述:
第一行输入一个整数T（1<=T<=10），表示数据组数。
每组数据占四行，第一行输入一个整数N（1<=N<=500000）；
第二行输入一个长度为N且仅包含数字0、1、2的字符串，第i个数字表示左起第i张餐桌已坐有的用餐人数；
第三行输入一个整数M（1<=M<=2N且保证排队的每个人进入食堂时都有可供选择的餐桌）；
第四行输入一个长度为M且仅包含字母M、F的字符串，若第i个字母为M，则排在第i的人为男性，否则其为女性。


输出描述:
每组数据输出占M行，第i行输出一个整数j（1<=j<=N），表示排在第i的人将选择左起第j张餐桌用餐。


输入例子1:
1
5
01102
6
MFMMFF

输出例子1:
2
1
1
3
4
4
 */

/*
使用三个小根堆，分别存储当前人数为0,1,2的三种桌子的桌号，记为pq0,pq1,pq2

以男职员为例：
先尝试坐人数为1的桌子，该桌子人数就变成了2，等价于：将pq1的堆顶弹出，同时推入pq2
如果没有人数为1的桌子了，等价于pq1为空，就去坐人数为0的桌子，等价于：将pq0的堆顶弹出，同时推入pq1
因为桌号存储在优先队列，所以堆顶的桌号总是最小的，保证每个人有多个选择时优先坐最左边的桌子。

女职员同理。
时间复杂度：O(MLogN)
输入输出用BufferedReader和BufferedWriter才能过，用System.out.println会超时。
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