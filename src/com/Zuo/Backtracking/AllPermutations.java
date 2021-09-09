package com.Zuo.Backtracking;
import java.util.ArrayList;
import java.util.List;

/*
����Ŀ��
    [a b c]ȫ����---->[abc][acb][bac][bca][cb][cab]

��˼·��
    ��һ�㣺��1λ�õ�b����0λ�ã���2λ�õ�c����0λ�ã����ǽ���
 */
public class AllPermutations
{
    public ArrayList<String> permutation(String str)
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

        for(int j = index; j < ch.length; j++)//���indexû����ֹ��index������ֶ�������index��λ�ã���ʱ��j�����ڳ��Ժ������������indexλ��
        {
            swap(ch,index,j);
            dfs(ch,index+1,res);
            swap(ch,index,j);//�ָ��ֳ�������
        }
    }

    public void swap(char[] ch , int i, int j)
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
