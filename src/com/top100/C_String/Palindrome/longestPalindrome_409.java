package com.top100.C_String.Palindrome;
/*
 * 【题目】
 *      给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *      在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 【例题】
 *      输入:"abccccdd"
 *      输出:7
 *      解释:我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 【思路】
 *      无论是使用数组还是使用哈希表，我们的宗旨都是一样的就是统计每一个字符出现的次数，
 *      题目中我们需要找到最长的回文串，根据题目提供的例子我们可以发现如果一个字符他的个数是偶数个那么他会被放在周围，
 *      而一个字符的个数是奇数个他一定会被放在中间。所以我们根据这个特征进行分类：
 *         1、如果对于每一个s中的字符，他的个数是偶数个，我们把所有的字符都算上
 *         2、如果对于每一个s中的字符，他的个数是奇数个，我们将他的数量减去1，变为偶数个，都算上。
 *         3、对于我们剪掉 1 的字符个数，我们在最后返回的时候，需要将他的多出的1个添加回来就是总体的数量
 *         (这里考虑"aaab"这个串无论是"aaa"还是"aba"都是最长的3，题目只问我们最长的长度是多少而不是都有那几个串)。
 */
public class longestPalindrome_409
{
    public int longestPalindrome(String s)
    {
        int[] character = new int[58];
        int result = 0;

        for(char c : s.toCharArray())
            character[c-'A']++;

        for(int i = 0; i < 58; i++)
        {
            if(character[i] % 2 == 0)    //是偶数
                result += character[i];
            else
                result += character[i]-1;  //是奇数
        }

        //如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return result >= s.length() ? result : result + 1;
    }
}
