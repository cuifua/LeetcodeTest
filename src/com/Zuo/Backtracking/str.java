package com.Zuo.Backtracking;

import java.util.HashMap;

/*
【题目】
    给定一个字符串str,给定一个字符串类型的数组arr
    arr里的每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的的拼出str来
    返回需要至少多少张贴纸可以完成这个任务
    例子：str = "babac"  arr = {"ba","c","abcd"}
    至少需要两张贴纸ba 和 abcd
【思路】
    最原始思路:
    把目标排序，因为使用顺序不做要求，那么最终目的就是使用几个贴纸能凑成需要的字符
    目标排好后--->"aabbc" 需要两个a两个b一个c
            a a b b c
          先使用ba,剩abc-->abc先使用ba，剩c/abc先使用c，剩ab/abc先使用abcd剩0
          先使用c剩aabb
          先使用abcd，剩ba
 */
public class str
{
    //dp 缓存，如果t已经算过了，直接返回dp中的值
    //t 剩余的目标
    //0...N 每一个字符串所含字符的词频统计
    //返回值是-1，表示map中的贴纸怎么也搞定不了target
    public int dfs(HashMap<String,Integer> dp,int[][]map,String rest)
    {
        if(dp.containsKey(rest))
            return dp.get(rest);

        //如果不存在，就放进缓存里
        int ans = Integer.MAX_VALUE;//最开始没方案，先假设无穷大个贴纸组合组成字符
        int n = map.length;//N种贴纸

        int[] tmap = new int[26];//tmap去代替rest
        char[] target = rest.toCharArray();
        for(char c : target)
            tmap[c-'a']++;

        for (int i = 0; i < n; i++)
        {
            if(map[i][target[0] - 'a'] == 0)//防止栈溢出
                continue;

            //i 是贴纸，j枚举a ~ z字符怎么变
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++)
            {
                if(tmap[j] > 0)//如果j这个字符是target需要的
                {
                    for (int k = 0; k < Math.max(0,tmap[j]-map[i][j]); k++)
                        sb.append((char)('a'+j));
                }
            }
            String s = sb.toString();
            int tmp = dfs(dp,map,s);
            if(tmp != -1)
                ans = Math.min(ans,1+tmp);
        }
        dp.put(rest, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(rest);

    }
}
