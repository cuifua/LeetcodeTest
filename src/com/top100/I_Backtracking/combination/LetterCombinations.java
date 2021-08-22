package com.top100.I_Backtracking.combination;
//【题目】    给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//           给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//【例题】    输入：digits = "23"
//           输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]


import java.util.ArrayList;
import java.util.List;

public class LetterCombinations
{
    public List<String> letterCombinations(String digits)
    {
        if (digits == null || digits.length() == 0)
            return new ArrayList<String>();

        //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
        //这里也可以用map，用数组可以更节省点内存
        String[] letter_map =
                {
                " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
                };

        List<String> res = new ArrayList<>();
        //先往队列中加入一个空字符
        res.add(" ");
        for (int i = 0; i < digits.length(); i++)
        {
            //由当前遍历到的字符，取字典表中查找对应的字符串
            String letters = letter_map[digits.charAt(i) - '0'];

            //计算出队列长度后，将队列中的每个元素挨个拿出来
            for (int j = 0; j < res.size(); j++)
            {
                //每次都从队列中拿出第一个元素
                String tmp = res.remove(0);

                //然后跟"def"这样的字符串拼接，并再次放到队列中
                for (int k = 0; k < letters.length(); k++)
                    res.add(tmp + letters.charAt(k));
            }
        }
        return res;
    }
}
