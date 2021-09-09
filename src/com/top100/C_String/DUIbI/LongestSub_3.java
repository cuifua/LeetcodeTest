package com.top100.C_String.DUIbI;

import java.util.HashMap;

/*
����Ŀ��
    ����һ���ַ��� s �������ҳ����в������ظ��ַ�����Ӵ��ĳ��ȡ�

��ʾ����
    ����: s = "abcabcbb"
    ���: 3
    ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��

��ʾ����
    ����: s = "bbbbb"
    ���: 1
    ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��

��ʾ����
    ����: s = "pwwkew"
    ���: 3
    ����: ��Ϊ���ظ��ַ�����Ӵ���?"wke"�������䳤��Ϊ 3��
 */
public class LongestSub_3
{
    public int lengthOfLongestSubstring(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;//���ڼ�¼����ظ��Ӵ��ĳ���
        int left = 0;//����������ָ��
        for (int i = 0; i < s.length() ; i++)
        {
            /**
             1�����ȣ��жϵ�ǰ�ַ��Ƿ������map�У�����������������ַ���ӵ�map���ַ����ַ��������±꣩,
             ��ʱû�г����ظ����ַ�����ָ�벻��Ҫ�仯����ʱ���ظ��Ӵ��ĳ���Ϊ��i-left+1����ԭ����maxLen�Ƚϣ�ȡ���ֵ��

             2�������ǰ�ַ� ch ������ map�У���ʱ��2�������
                1����ǰ�ַ������ڵ�ǰ��Ч���Ӷ��У��磺abca�������Ǳ������ڶ���a����ǰ��Ч��Ӷ��� abc�������ֱ�����a��
                   ��ô��ʱ���� left Ϊ map.get(a)+1=1����ǰ��Ч�Ӷθ���Ϊ bca��
                2����ǰ�ַ��������ڵ�ǰ���Ч�Ӷ��У��磺abba�����������a,b��map����ʱleft=0�����������b������map�а���b��
                   ����b���������Ч�Ӷ��У�����1������������Ǹ��� left=map.get(b)+1=2����ʱ�Ӷθ���Ϊ b������map����Ȼ����a��map.get(a)=0��
                   ������Ǳ�����a������a������map�У���map.get(a)=0�����������1��һ�������ͻᷢ�� left=map.get(a)+1=1��ʵ���ϣ�left��ʱ
                   Ӧ�ò��䣬leftʼ��Ϊ2���Ӷα�� ba�Ŷԡ�

             Ϊ�˴�������2�����������ÿ�θ���left��left=Math.max(left , map.get(ch)+1).
             ���⣬����left�󣬲���ԭ���� s.charAt(i) �Ƿ�����Ӷ��У����Ƕ�Ҫ�� s.charAt(i) ��λ�ø���Ϊ��ǰ��i��
             ��˴�ʱ�µ� s.charAt(i) �Ѿ����뵽 ��ǰ����Ӷ��У�
             */
            if(map.containsKey(s.charAt(i)))
                left = Math.max(left , map.get(s.charAt(i))+1);

            //�����Ƿ����left����Ҫ���� s.charAt(i) ��λ�ã�
            map.put(s.charAt(i) , i);
            maxLen = Math.max(maxLen , i-left+1);
        }

        return maxLen;
    }
}
