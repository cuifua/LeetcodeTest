package com.Company.xiaomi;

/**
 * @Author cuifua
 * @Date 2021/9/2 18:02
 * @Version 1.0
 */
/*
����һ���ַ���str���ж��ǲ���������Ч�������ַ���(������Ч��������һ������ƥ�䷽����ʹÿ�������ַ������ҵ���Ӧ�ķ������ţ����ַ����в������������ַ�)��
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