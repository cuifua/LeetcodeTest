package com.Company;

import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        /*
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            int im = sc.nextInt();
            int in = sc.nextInt();
            //System.out.println("m=" + im + "," + "n=" + in);

            int[] mint = new int[im];
            int[] nint = new int[in];

            for (int p = 0; p < im; p++)
            {
                mint[p++] = sc.nextInt();
            }


            for (int k = 0; k < in; k++)
            {
                nint[k++] = sc.nextInt();
            }


            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < im; i++)
            {
                list.add(mint[i]);
            }


            for (int j = 0; j < in; j++)
            {
                list.add(nint[j]);
            }


            int[] temp = new int[list.size()];
            for (int i = 0; i < list.size(); i++)
            {
                temp[i] = list.get(i);
            }


            Arrays.sort(temp);

            for (int n : temp)
            {
                System.out.print(n);
            }

            }

        }

         */
        /*
        String str = Scanner.nextLine();
        String[] split = str.split(",");
        int m = split[0].charAt(2) - '0';
        int n = split[1].charAt(2) - '0';

        int[] A = new int[m+n];
        int[] B = new int[n];

        String str1 = Scanner.nextLine();
        String[] split1 = str1.split(",");
        for(int i = 0; i < m; i++)
            A[i] = Integer.parseInt(split1[i]);

        String str2 = Scanner.nextLine();
        String[] split2 = str2.split(",");
        for(int i = 0; i < n; i++)
            B[i] = Integer.parseInt(split2[i]);
         */

                Scanner scan = new Scanner(System.in);
                String[] s = scan.nextLine().split(",");

                String s1 = s[0].substring(2, s[0].length());
                int m = Integer.parseInt(s1);

                String s2 = s[1].substring(2, s[1].length());
                int n = Integer.parseInt(s1);

                int[] arr1 = new int[m + n];
                int[] arr2 = new int[n];

                String input1 = scan.nextLine();
                String[] str1 = input1.split(",");
                for (int i = 0; i < m; i++)
                    arr1[i] = Integer.parseInt(str1[i]);

                String input2 = scan.nextLine();
                String[] str2 = input2.split(",");
                for (int j = 0; j < n; j++)
                    arr2[j] = Integer.parseInt(str2[j]);


                int sum = n + m - 1;
                while (m >= 1 && n >= 1)
                {
                    if (arr1[m - 1] >= arr2[n - 1])
                    {
                        arr1[sum--] = arr1[m - 1];
                        m--;
                    } else
                    {
                        arr1[sum--] = arr2[n - 1];
                        n--;
                    }
                }
                if (m == 0)
                {
                    while (n >= 1)
                    {
                        arr1[sum--] = arr1[n - 1];
                        n--;
                    }
                }
                int sum2 = arr1.length;
                for (int k = 0; k < sum2; k++)
                {
                    System.out.print(arr1[k]);
                    if (k != sum2 - 1)
                        System.out.print(" ");
                }
            }
}

class Demo
{
    /**
     * 成员变量(俗称全局变量)，//有缺省值为0
     * 静态变量(也称类变量)，带static的
     * 实例变量，不带static的
     * 局部变量 //无缺省值，需要初始化
     */
    static int x; //静态变量，有缺省值为0
    int y ;//实例变量

    public static void main(String args[])
    {
        System.out.println(x);//访问静态变量，值=0，可以直接访问

        int x=5;//局部变量，必须初始化
        System.out.println(x);//访问局部变量，值=5

        Demo demo = new Demo();//必须创建实例，必须实例化
        System.out.println(demo.y);//通过实例访问实例变量,值=0
    }
}

