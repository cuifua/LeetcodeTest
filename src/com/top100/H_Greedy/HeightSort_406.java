package com.top100.H_Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
【题目】
    假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
    每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
    请你重新构造并返回输入数组people 所表示的队列。
    返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。

【示例】
    输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
    输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

【思路】
    先排序，再插队，排序的时候第一列（身高降序，高的在前面）第二列（前面有几位这个符号升序，前面的人越少，越排前）
 */
public class HeightSort_406
{
    public int[][] reconstructQueue(int[][] people)
    {
        //按数组第一个元素进行降序，按第二个元素进行升序
        Arrays.sort(people, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] person1, int[] person2)
            {
                if (person1[0] != person2[0])//第一个元素不相等时，第一个元素降序
                    return person2[0] - person1[0];

                else//第一个元素相等时，第二个元素升序
                    return person1[1] - person2[1];
            }
        });

        //新建一个list,用于保存结果集
        List<int[]> list = new LinkedList<>();

        for (int i = 0; i < people.length; i++)
        {
            if (list.size() > people[i][1])//结果集中元素个数大于第i个人前面应有的人数时，将第i个人插入到结果集的 people[i][1]位置
                list.add(people[i][1],people[i]);

            else //结果集中元素个数小于等于第i个人前面应有的人数时，将第i个人追加到结果集的后面
                list.add(list.size(),people[i]);
        }

        //将list转化为数组，然后返回
        return list.toArray(new int[list.size()][]);
    }

}
