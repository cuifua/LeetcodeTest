package com.top100.C_String.DUIbI;
/*
大名鼎鼎的杀人不见血的KMP算法
【题目】实现strStr()函数。
       给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。

【例题】 输入: haystack = "hello", needle = "ll"
        输出: 2

        输入: haystack = "aaaaa", needle = "bba"
        输出: -1

 */
public class strStr
{
        public void getNext(int[] next, String s)
        {
            int j = -1;
            next[0] = j;
            for (int i = 1; i<s.length(); i++){
                while(j>=0 && s.charAt(i) != s.charAt(j+1)){
                    j=next[j];
                }

                if(s.charAt(i)==s.charAt(j+1)){
                    j++;
                }
                next[i] = j;
            }
        }

        public int strStr(String haystack, String needle)
        {
            if(needle.length()==0)
                return 0;


            int[] next = new int[needle.length()];
            getNext(next, needle);
            int j = -1;

            for(int i = 0; i<haystack.length();i++)
            {

                while(j>=0 && haystack.charAt(i) != needle.charAt(j+1))
                    j = next[j];

                if(haystack.charAt(i)==needle.charAt(j+1))
                    j++;

                if(j==needle.length()-1)
                    return (i-needle.length()+1);
            }

            return -1;
        }
}
