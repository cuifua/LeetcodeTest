package com.top100.C_String.DUIbI;

/*
【题目】
    将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
    输入描述：
    输入一个字符串,包括数字字母符号,可以为空
    返回值描述：
    如果是合法的数值表达则返回该数字，否则返回0
【示例】
    输入：
    "+2147483647"

    返回值：
    2147483647
复制
【示例】
    输入：
    "1a33"

    返回值：
    0
 */
public class StrToInt_Noff49
{
    //1、空格打头，删除空格
    //2、符号打头，记录符号
    //3、数字打头，直接开始处理转换
    //4、非以上三种情况，return 0
    public int StrToInt(String str) {

        if(str==null || str.length()==0)
            return 0;

        char[] ch = str.toCharArray();
        int flag = 1;//无符号默认是1

        if(ch[0] == '-')
        {
            flag = -1;
            ch[0] = '0';
        }

        if(ch[0] == '+')
            ch[0] = '0';//+-号置为零

        int res = 0;
        for(int i=0; i<=str.length()-1; ++i)
        {
            res *= 10;//乘10放在+之前就不用判断了
            int num = ch[i]-'0';
            if(0<=num && num<=9)
                res += num;

            else
                return 0;//出现非法字符
        }
        return res*=flag;
    }
    //时间O(n),空间O(n)
}
