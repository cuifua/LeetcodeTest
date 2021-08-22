package com.top100.C_String.Reverse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 【题目】
 *      给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 *      单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *      请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 * 【例题】
 *      输入：s = "the sky is blue"
 *      输出："blue is sky the"
 * 【思路】
 *      1、使用 split 将字符串按空格分割成字符串数组；
 *      2、使用 reverse 将字符串数组进行反转；
 *      3、使用 join 方法将字符串数组拼成一个字符串。
 */
public class ReverseWord_151
{
    public String reverseWords(String s)
    {
        // 除去开头和末尾的空白字符
        s = s.trim();

        //1、正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));

        //2、使用 reverse 将字符串数组进行反转；
        Collections.reverse(wordList);

        //3、使用 join 方法将字符串数组拼成一个字符串。
        return String.join(" ", wordList);
    }
}
