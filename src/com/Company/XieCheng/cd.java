package com.Company.XieCheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author cuifua
 * @Date 2021/9/9 20:21
 * @Version 1.0
 */
public class cd
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        List<String> path = new ArrayList<>();
        path.add("\\");

        while(m-- > 0)
        {
            while (sc.hasNextLine())
            {
                String[] strcd = sc.nextLine().split(" ");
                if(strcd[0] == "cd")
                {
                    if(strcd[1] != "..")
                        path.add("\\"+strcd[1]);
                    else
                        path.remove(path.size()-1);
                }
                if(strcd[0] == "pwd")
                    System.out.println(path);
            }
        }
    }
}
