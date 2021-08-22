package com.top100.C_String.DUIbI;
/*
 * ����Ŀ��
 *      ���������ַ���s��t���ж������Ƿ���ͬ���ġ�
 *      ���s�е��ַ����԰�ĳ��ӳ���ϵ�滻�õ�t����ô�������ַ�����ͬ���ġ�
 *      ÿ�����ֵ��ַ���Ӧ��ӳ�䵽��һ���ַ���ͬʱ���ı��ַ���˳�򡣲�ͬ�ַ�����ӳ�䵽ͬһ���ַ��ϣ���ͬ�ַ�ֻ��ӳ�䵽ͬһ���ַ��ϣ��ַ�����ӳ�䵽�Լ�����
 * �����⡿
 *      ���룺s = "egg", t = "add"
 *      �����true
 *
 *      ���룺s = "foo", t = "bar"
 *      �����false
 *
 *      ���룺s = "paper", t = "title"
 *      �����true
 * ��˼·��
 *      ��¼һ���ַ��ϴγ��ֵ�λ�ã���������ַ����е��ַ��ϴγ��ֵ�λ��һ������ô������ͬ����
 */
public class isIsomorphic_205
{
    public boolean isIsomorphic(String s,String t)
    {
        int[] indexOfs = new int[256];
        int[] indexOft = new int[256];

        for(int i = 0; i < s.length(); i++)
        {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(indexOfs[sc] != indexOft[tc])
                return false;

            indexOfs[sc] = i + 1;
            indexOft[tc] = i + 1;
        }
        return true;
    }
}
