package com.top100.C_String.DUIbI;
/*
����Ŀ����ʵ��һ�����������ַ��� s �е�ÿ���ո��滻��"%20"��
�����⡿���룺s = "We are happy."
       �����"We%20are%20happy."
 */
public class ReplaceSpace
{
    public String replace(String s)
    {       /*
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == ' ')
                sb.append("%20");
            else
                sb.append(ch);
        }
        return sb.toString();
    }

             */
        char[] chars = new char[s.length() * 3];
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == ' ')
            {
                chars[i++] = '%';
                chars[i++] = '2';
                chars[i++] = '0';
            }
            else
                chars[i++] = c;
        }
        return chars.toString();
    }
}



