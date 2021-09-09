package com.top100.C_String.DUIbI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
【题目】
    输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
    例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
【示例】
    输入：
    [3,32,321]

    返回值：
    "321323"
 */
public class PrintMinNum_Noff32
{
    public String PrintMinNumber(int [] numbers)
    {
        if(numbers.length == 0 || numbers == null)
            return "";

        //1、创建n个字符串数组
        int n = numbers.length;
        String[] str = new String[n];

        //2、将数字字符串的数字写进字符串数组
        for(int i = 0; i < n; i++)
            str[i] = numbers[i] + "";

        //3、比较升序si比较小放前面
        Arrays.sort(str,(s1, s2) -> {
            return (s1+s2).compareTo(s2+s1);
        });

        //4、比较后的字符串数组写出
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
