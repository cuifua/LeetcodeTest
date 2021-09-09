package com.top100.J_Dynamic.islands;

/*
����Ŀ��
    ����һ����'1'��½�أ��� '0'��ˮ����ɵĵĶ�ά����������������е����������
    �������Ǳ�ˮ��Χ������ÿ������ֻ����ˮƽ�����/����ֱ���������ڵ�½�������γɡ�
    ���⣬����Լ��������������߾���ˮ��Χ��

��ʾ����
    ���룺grid = [
      ["1","1","1","1","0"],
      ["1","1","0","1","0"],
      ["1","1","0","0","0"],
      ["0","0","0","0","0"]
    ]
�����1

��ʾ����
    ���룺grid = [
      ["1","1","0","0","0"],
      ["1","1","0","0","0"],
      ["0","0","1","0","0"],
      ["0","0","0","1","1"]
    ]
    �����3
 */
public class islandsNum_200
{
    public int numIslands(char[][] grid)
    {
        int count = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int row,int col)
    {
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0)
            return;

        if(grid[row][col] != '1')      return;//���ǵ���ֱ�ӷ���

        grid[row][col] = '2';//�жϹ�����2

        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);
    }
}
