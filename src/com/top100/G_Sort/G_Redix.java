package com.top100.G_Sort;

import org.junit.Test;

import java.util.Arrays;

/*
���������˵��:
(1)���������ǶԴ�ͳͰ�������չ���ٶȺܿ졣
(2)���������Ǿ���Ŀռ任ʱ��ķ�ʽ��ռ���ڴ�ܴ�, ���Ժ����������� ʱ��������� OutOfMemoryError ��
(3)�����������ȶ��ġ���ע:�ٶ��ڴ�����ļ�¼�����У����ڶ��������ͬ�Ĺؼ��ֵļ�¼��������������Щ��¼����Դ��򱣳ֲ��䣬
    ��ԭʼ����Ϊ{1,3,2,3,5}���������Ϊ{1,2,3,3,5},��ʱ��һ��3�����������Ȼ�ڵڶ�������ǰ�棬������������㷨���ȶ��ģ������Ϊ���ȶ��ģ�
(4)�и��������飬���ǲ��û�����������������
 */

//====================���ʾ��ǰ���λ���� �ȱȽ����д������ָ�λ����λ�����ּ��ͷŽ��������е�Ͱ���ٽ�����źõİ���ʮλ�ţ��źú��հ�λ....
public class G_Redix
{
    public void redix(int[] nums)
    {
        int[][] bucket = new int[10][nums.length];
        int[] bucketElementCounts = new int[10];//ÿ��Ͱ��Ԫ�ظ���

        //������������������Ǹ�������Ϊֻ��֪�������Ǹ��������ǲ�֪���������Ǽ�λ�������ǧλ���Ǿ�ѭ���ĴΣ���λ���Σ��Դ�����
        int max = nums[0];
        for(int i = 1; i < nums.length; i++)
            max = Math.max(max,nums[i]);

        int maxBit = (max + "").length();//С���ɣ���int���ϡ�������ַ����������ַ�����.length()���������һ����λ
        for (int i = 0; i < maxBit; i++)
        {
            for (int j = 0; j < nums.length; j++)
            {
                int value = nums[j] / (int)Math.pow(10,i) % 10;//�����Ͱ�ı�ţ�����48�������Ϊ4
                bucket[value][bucketElementCounts[value]] = nums[j];//bucket[4��Ͱ][4��Ͱ��value����]
                bucketElementCounts[value]++;
            }

            int index = 0;
            for(int k =0; k < bucketElementCounts.length; k++)//����ÿ��Ͱ
            {
                if(bucketElementCounts[k] != 0)//��ʹ���Ͱ�������֣��������²���
                {
                    for(int x = 0; x < bucketElementCounts[k]; x++)//����ÿ��Ͱ��Ԫ��
                        nums[index++] = bucket[k][x];
                }
                bucketElementCounts[k] = 0;//���Ͱ
            }
        }
    }


    @Test
    public void RedixTest()
    {
        int[] num = {49, 3, 65, 897, 76, 13, 27, 50};
        redix(num);
        System.out.println("�ź�������飺" + Arrays.toString(num));
    }
}
