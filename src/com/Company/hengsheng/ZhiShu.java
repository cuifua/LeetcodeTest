package com.Company.hengsheng;

/**
 * @Author cuifua
 * @Date 2021/9/8 19:26
 * @Version 1.0
 */
public class ZhiShu
{
    public static void main(String[] args)
    {
        int count = 0;
        for (int i = 2; i <= 1000; i++)
        {
            boolean isZhi = false;
            for (int j = 2; j < i; j++)
            {
                if(i % j == 0)
                {
                    isZhi = true;
                    break;
                }
            }

            if(isZhi)
            {
                System.out.println(i + "");
                count++;
                if (count % 8 == 0)
                {
                    System.out.println();
                }
            }
        }
    }
}
