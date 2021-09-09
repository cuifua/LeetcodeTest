package com.top100.I_Backtracking.Other;

/*
����Ŀ��
    ����һ��m x n ��ά�ַ�����board ��һ���ַ�������word �����word �����������У����� true �����򣬷��� false ��
    ���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ��
�����⡿
    ���룺board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    �����true
 */
public class SearchWord_79
{
    public boolean find;
    public boolean exist(char[][] board, String word)
    {
        if(board == null)   return false;

        int m = board.length,n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        find = false;

        for(int i = 0; i< m; i++)
        {
            for(int j = 0; j < n; j++)
                backtracking(i,j,board,word,visited,0);
        }
        return find;
    }

    public void backtracking(int i, int j, char[][] board, String word,boolean[][] visited, int pos)
    {
        // �����߽硢�Ѿ����ʹ������ҵ�Ŀ�굥�ʡ����̸��е�ǰ�ַ��Ѿ���Ŀ���ַ���һ����
        if(i<0 || i>= board.length)         return;
        if(j<0 || j >= board[0].length)     return;
        if(visited[i][j])                   return;//�Ѿ����ʹ�
        if(find)                            return;//���ҵ�Ŀ�굥��
        if(board[i][j]!=word.charAt(pos))   return;//���̸��е�ǰ�ַ��Ѿ���Ŀ���ַ���һ����

        if(pos == word.length()-1)
        {
            find = true;
            return;
        }

        visited[i][j] = true;  // �޸ĵ�ǰ�ڵ�״̬
        backtracking(i+1, j, board, word, visited, pos+1);  // �����ӽڵ�
        backtracking(i-1, j, board, word, visited, pos+1);
        backtracking(i, j+1, board, word, visited, pos+1);
        backtracking(i, j-1, board, word, visited, pos+1);
        visited[i][j] = false; // �����޸�
    }
}
