package com.Company.hengsheng;

/**
 * @Author cuifua
 * @Date 2021/9/8 19:26
 * @Version 1.0
 */
public class YangHui
{
    public static void main(String[] args)
    {
        int[][] yanghui = new int[12][];

        for(int i = 0; i < yanghui.length; i++)
        {
            yanghui[i] = new int[i+1];//第0行有1个元素,第一行有2个元素
            yanghui[i][0] = yanghui[i][i] = 1;

            if(i > 1)
            {
                for(int j = 1; j < yanghui[i].length-1; j++)
                    yanghui[i][j] = yanghui[i-1][j] + yanghui[i-1][j-1];
            }
        }

        for (int i = 0; i < yanghui.length; i++)
        {
            for (int j = 0; j < yanghui[i].length; j++)
                System.out.println(yanghui[i][j] + "");

            System.out.println();
        }
    }
}
