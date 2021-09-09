package com.top100.A_Array.Other;

import java.util.Arrays;

/*
��˼·��
    ������ intervals ��ʾ���ɸ�����ļ��ϣ����е�������Ϊ intervals[i] = [starti, endi] ��
    ����ϲ������ص������䣬������һ�����ص����������飬��������ǡ�ø��������е��������䡣

��ʾ����
    ���룺intervals = [[1,3],[2,6],[8,10],[15,18]]
    �����[[1,6],[8,10],[15,18]]
    ���ͣ����� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
��ʾ����
    ���룺intervals = [[1,4],[4,5]]
    �����[[1,5]]
    ���ͣ����� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣
 */
public class merge_56
{
    public int[][] merge(int[][] intervals)
    {
        // �Ȱ���������ʼλ������
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        // ��������
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals)
        {
            // �����������ǿյģ����ߵ�ǰ�������ʼλ�� > �������������������ֹλ�ã�
            // �򲻺ϲ���ֱ�ӽ���ǰ������������顣
            if (idx == -1 || interval[0] > res[idx][1])
                res[++idx] = interval;

             else
                res[idx][1] = Math.max(res[idx][1], interval[1]); // ��֮����ǰ����ϲ������������������
        }

        return Arrays.copyOf(res, idx + 1);
    }
}
