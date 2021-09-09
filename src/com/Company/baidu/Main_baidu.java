package com.Company.baidu;

import java.util.Scanner;

public class Main_baidu
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int one = sc.nextInt();
        int two = sc.nextInt();

        int[][] old = new int[one][two];
        for(int i = 0; i < one; i++)
        {
            for(int j = 0; j < two; j++)
                old[i][j] = sc.nextInt();
        }

        int [][] now = new int[one*one][two*two];
        for(int wi = 0; wi < now.length; wi += one)
        {
            for(int wj = 0; wj < now[0].length; wj += two)
            {
                int target = old[wi/one][wj/two];
                tuozhan(now,wi,wi,one,two,target);
            }
        }

        for(int p = 0; p < one*one; p++)
        {
            for(int q = 0; q < two*two; q++)
                System.out.println(now[p][q]);
        }
    }

    public static void tuozhan(int[][] nums, int h, int z , int one, int two,int target)
    {
        for(int i = h; i < h + one; i++)
        {
            for(int j = z; j < z +two; j++)
            {
                nums[i][j] = target;
            }
        }
    }
}
