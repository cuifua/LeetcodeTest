package com.top100.I_Backtracking.Other;

/*
【题目】
    给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用
【例题】
    输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    输出：true
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
        // 超出边界、已经访问过、已找到目标单词、棋盘格中当前字符已经和目标字符不一致了
        if(i<0 || i>= board.length)         return;
        if(j<0 || j >= board[0].length)     return;
        if(visited[i][j])                   return;//已经访问过
        if(find)                            return;//已找到目标单词
        if(board[i][j]!=word.charAt(pos))   return;//棋盘格中当前字符已经和目标字符不一致了

        if(pos == word.length()-1)
        {
            find = true;
            return;
        }

        visited[i][j] = true;  // 修改当前节点状态
        backtracking(i+1, j, board, word, visited, pos+1);  // 遍历子节点
        backtracking(i-1, j, board, word, visited, pos+1);
        backtracking(i, j+1, board, word, visited, pos+1);
        backtracking(i, j-1, board, word, visited, pos+1);
        visited[i][j] = false; // 撤销修改
    }
}
