package com.top100.C_String.Palindrome;
/*
 * 【题目】
 *      给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
        回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * 【例题】
 *      输入：x = 121
 *      输出：true
 *
 *      输入：x = -121
 *      输出：false
 *      解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 *      输入：x = 10
 *      输出：false
 *      解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 【思路】
 *      举个例子：1221 这个数字。
 *      通过计算 1221 / 1000， 得首位1
 *      通过计算 1221 % 10， 可得末位 1
 *      进行比较
 *      再将 22 取出来继续比较

 */
public class isPalindrome_9
{
    public boolean isPalindrome(int x)
    {
        //边界判断
        if (x < 0) return false;

        int div = 1;
        while (x / div >= 10)
            div *= 10;

        while (x > 0)
        {
            int left = x / div;
            int right = x % 10;

            if (left != right)
                return false;

            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public boolean isPalindrome(String s)//这可不就是重构吗【类型不同】【顺序不同】【数量不同】
    {
       if(s.length() == 1)   return true;

       int i = 0;
       int j = s.length()-1;

       while(i < j)
       {
           char left = s.charAt(i);
           char right = s.charAt(j);

           if(! Character.isLetterOrDigit(left))  i++;
           else if(! Character.isLetterOrDigit(right))  j--;
           else
           {
               left = Character.toLowerCase(left);
               right = Character.toLowerCase(right);
               if(left != right)  return false;
               i++;
               j--;
           }
       }
    return true;
    }
}
