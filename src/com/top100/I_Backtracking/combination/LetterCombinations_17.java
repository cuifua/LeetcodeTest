package com.top100.I_Backtracking.combination;
//【题目】    给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//           给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//【例题】    输入：digits = "23"
//           输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]


import java.util.ArrayList;
import java.util.List;

public class LetterCombinations_17
{
    //设置全局列表存储最后的结果
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits)
    {
        if (digits == null || digits.length() == 0)   return list;

        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);//迭代处理
        return list;
    }

    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
    StringBuilder temp = new StringBuilder();

    //比如digits如果为"23",num 为0，则str表示2对应的 abc
    public void backTracking(String digits, String[] numString, int num)
    {
        //遍历全部一次记录一次得到的字符串
        if (num == digits.length())
        {
            list.add(temp.toString());
            return;
        }

        //str 表示当前num对应的字符串
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++)
        {
            temp.append(str.charAt(i));
            //c
            backTracking(digits, numString, num + 1);
            //剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
