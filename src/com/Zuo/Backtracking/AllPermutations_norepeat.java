package com.Zuo.Backtracking;

import java.util.ArrayList;

/*
����Ŀ��
    ��ӡһ���ַ�����ȫ�����У�Ҫ�󲻳����ظ�������

 ��˼·��
    ��β���set�ˣ���Ϊ��set��ʵ���ǽ����н��������Ժ�ȥ�أ����������ǽ�����·��ȫ���߹�һ����
    ��visit[]����ʾһ���ַ���û����������ѡ���ʱ��Ͷ�ɱ�˼������ظ�����·��Ч�ʸ���
 */
public class AllPermutations_norepeat
{
    public ArrayList<String> permutationNoRepeat(String str)
    {
        ArrayList<String> res = new ArrayList<>();
        if(str.length() == 0 || str == null)  return res;

        char[] ch = str.toCharArray();
        dfs(ch,0,res);
        return res;
    }

    /**
     * @param ch    ch[index...] ch�����������ֶ��л�������index�±꣬ǰ����Ѿ��̶����ˣ����ܱ��ˣ�ֻ��������
     * @param index
     * @param res   �����
     */
    public void dfs(char[] ch, int index, ArrayList<String> res)
    {
        if(index == ch.length)
            res.add(String.valueOf(ch));//�Ѵ�ʱ�ַ����͵�����['a','b','c']ת���ɡ�abc��

        boolean[] visit = new boolean[26];//[0 1 2 ..25] ������a��û�г��ֹ���b��û�г��ֹ�....
        for(int j = index; j < ch.length; j++)//���indexû����ֹ��index������ֶ�������index��λ�ã���ʱ��j�����ڳ��Ժ������������indexλ��
        {
            if(! visit[ch[j]-'a'])
            {
                visit[ch[j]-'a'] = true;//�Ǽ�һ�£��Ժ�ͳ��ֹ�
                swap(ch,index,j);
                dfs(ch,index+1,res);
                swap(ch,index,j);//�ָ��ֳ�������
            }

        }
    }

    public void swap(char[] ch , int i, int j)
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
