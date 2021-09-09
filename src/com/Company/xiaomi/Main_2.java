package com.Company.xiaomi;

/**
 * @Author cuifua
 * @Date 2021/9/2 18:02
 * @Version 1.0
 */
/*
给定一个字符串str，判断是不是整体有效的括号字符串(整体有效：即存在一种括号匹配方案，使每个括号字符均能找到对应的反向括号，且字符串中不包含非括号字符)。
 */
import java.util.Scanner;

public class Main_2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
        {
            String input = scanner.next();
            while(true)
            {
                if(input.equals(""))
                {
                    System.out.println("YES");
                    break;
                }
                else if(input.equals(input.replace("()","")))
                {
                    System.out.println("NO");
                    break;
                }
                else
                    input=input.replace("()","");

            }
        }
    }
}