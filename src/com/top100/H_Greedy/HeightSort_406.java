package com.top100.H_Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
����Ŀ��
    �����д���˳���һȺ��վ��һ�����У����� people ��ʾ������һЩ�˵����ԣ���һ����˳�򣩡�
    ÿ�� people[i] = [hi, ki] ��ʾ�� i ���˵����Ϊ hi ��ǰ�� ���� �� ki ����ߴ��ڻ���� hi ���ˡ�
    �������¹��첢������������people ����ʾ�Ķ��С�
    ���صĶ���Ӧ�ø�ʽ��Ϊ���� queue ������ queue[j] = [hj, kj] �Ƕ����е� j ���˵����ԣ�queue[0] �����ڶ���ǰ����ˣ���

��ʾ����
    ���룺people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
    �����[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

��˼·��
    �������ٲ�ӣ������ʱ���һ�У���߽��򣬸ߵ���ǰ�棩�ڶ��У�ǰ���м�λ�����������ǰ�����Խ�٣�Խ��ǰ��
 */
public class HeightSort_406
{
    public int[][] reconstructQueue(int[][] people)
    {
        //�������һ��Ԫ�ؽ��н��򣬰��ڶ���Ԫ�ؽ�������
        Arrays.sort(people, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] person1, int[] person2)
            {
                if (person1[0] != person2[0])//��һ��Ԫ�ز����ʱ����һ��Ԫ�ؽ���
                    return person2[0] - person1[0];

                else//��һ��Ԫ�����ʱ���ڶ���Ԫ������
                    return person1[1] - person2[1];
            }
        });

        //�½�һ��list,���ڱ�������
        List<int[]> list = new LinkedList<>();

        for (int i = 0; i < people.length; i++)
        {
            if (list.size() > people[i][1])//�������Ԫ�ظ������ڵ�i����ǰ��Ӧ�е�����ʱ������i���˲��뵽������� people[i][1]λ��
                list.add(people[i][1],people[i]);

            else //�������Ԫ�ظ���С�ڵ��ڵ�i����ǰ��Ӧ�е�����ʱ������i����׷�ӵ�������ĺ���
                list.add(list.size(),people[i]);
        }

        //��listת��Ϊ���飬Ȼ�󷵻�
        return list.toArray(new int[list.size()][]);
    }

}
