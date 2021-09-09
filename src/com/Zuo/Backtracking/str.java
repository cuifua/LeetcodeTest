package com.Zuo.Backtracking;

import java.util.HashMap;

/*
����Ŀ��
    ����һ���ַ���str,����һ���ַ������͵�����arr
    arr���ÿһ���ַ���������һ����ֽ������԰ѵ����ַ�����ʹ�ã�Ŀ�ĵ�ƴ��str��
    ������Ҫ���ٶ�������ֽ��������������
    ���ӣ�str = "babac"  arr = {"ba","c","abcd"}
    ������Ҫ������ֽba �� abcd
��˼·��
    ��ԭʼ˼·:
    ��Ŀ��������Ϊʹ��˳����Ҫ����ô����Ŀ�ľ���ʹ�ü�����ֽ�ܴճ���Ҫ���ַ�
    Ŀ���źú�--->"aabbc" ��Ҫ����a����bһ��c
            a a b b c
          ��ʹ��ba,ʣabc-->abc��ʹ��ba��ʣc/abc��ʹ��c��ʣab/abc��ʹ��abcdʣ0
          ��ʹ��cʣaabb
          ��ʹ��abcd��ʣba
 */
public class str
{
    //dp ���棬���t�Ѿ�����ˣ�ֱ�ӷ���dp�е�ֵ
    //t ʣ���Ŀ��
    //0...N ÿһ���ַ��������ַ��Ĵ�Ƶͳ��
    //����ֵ��-1����ʾmap�е���ֽ��ôҲ�㶨����target
    public int dfs(HashMap<String,Integer> dp,int[][]map,String rest)
    {
        if(dp.containsKey(rest))
            return dp.get(rest);

        //��������ڣ��ͷŽ�������
        int ans = Integer.MAX_VALUE;//�ʼû�������ȼ�����������ֽ�������ַ�
        int n = map.length;//N����ֽ

        int[] tmap = new int[26];//tmapȥ����rest
        char[] target = rest.toCharArray();
        for(char c : target)
            tmap[c-'a']++;

        for (int i = 0; i < n; i++)
        {
            if(map[i][target[0] - 'a'] == 0)//��ֹջ���
                continue;

            //i ����ֽ��jö��a ~ z�ַ���ô��
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++)
            {
                if(tmap[j] > 0)//���j����ַ���target��Ҫ��
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
