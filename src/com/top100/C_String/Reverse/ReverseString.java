package com.top100.C_String.Reverse;

import org.junit.Test;

/*
·´×ª×Ö·û´®¡£
 */
public class ReverseString
{
    public void reserve (char [] s)
    {
        for(int i = 0,j = s.length-1; i < s.length/2; i++,j--)
        {
            swap(s,i,j);
        }
        System.out.println(s);
    }

    public void swap (char[] s, int i, int j)
    {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    @Test
    public void test()
    {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reserve(s);
    }
}