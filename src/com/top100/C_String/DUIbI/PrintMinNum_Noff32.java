package com.top100.C_String.DUIbI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
����Ŀ��
    ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
    ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
��ʾ����
    ���룺
    [3,32,321]

    ����ֵ��
    "321323"
 */
public class PrintMinNum_Noff32
{
    public String PrintMinNumber(int [] numbers)
    {
        if(numbers.length == 0 || numbers == null)
            return "";

        //1������n���ַ�������
        int n = numbers.length;
        String[] str = new String[n];

        //2���������ַ���������д���ַ�������
        for(int i = 0; i < n; i++)
            str[i] = numbers[i] + "";

        //3���Ƚ�����si�Ƚ�С��ǰ��
        Arrays.sort(str,(s1, s2) -> {
            return (s1+s2).compareTo(s2+s1);
        });

        //4���ȽϺ���ַ�������д��
        StringBuffer sb = new StringBuffer();
        for(String s : str)
            sb.append(s);

        return sb.toString();
    }


    public int FirstNotRepeatingChar(String str)
    {
        Map<Character,Boolean> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++)
        {
            if(map.containsKey(str.charAt(i)))
                map.put(str.charAt(i),false);
            else
                map.put(str.charAt(i),true);
        }

        for(int i = 0; i < str.length(); i++)
        {
            if(map.get(str.charAt(i)))
                return i;
        }
        return -1;
    }
}
