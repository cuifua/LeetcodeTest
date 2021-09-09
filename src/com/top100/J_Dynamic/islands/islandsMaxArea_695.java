package com.top100.J_Dynamic.islands;

/*
����Ŀ��
    ����һ��������һЩ 0 �� 1 �ķǿն�ά���� grid��һ��������һ�����ڵ� 1������½�أ���
    ����ġ����ڡ�Ҫ������ 1 ������ˮƽ������ֱ���������ڡ�����Լ��� grid ���ĸ���Ե���� 0�������󣩰�Χ��
    �ҵ������Ķ�ά���������ĵ�����������û�е��죬�򷵻����Ϊ 0
��˼·��
    �����Ŀֻ��Ҫ��ÿ�������� DFS ���������ÿ�����������Ϳ����ˡ���������ķ���Ҳ�ܼ򵥣��������£�ÿ������һ�����ӣ��Ͱ������һ��
 */
public class islandsMaxArea_695
{
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[0].length; c++)
            {
                if (grid[r][c] == 1)
                {
                    int a = area(grid, r, c);
                    res = Math.max(res, a);
                }
            }
        }
        return res;
    }

    int area(int[][] grid, int row, int col)
    {
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0)
            return -1;

        if (grid[row][col] != 1)
            return 0;

        grid[row][col] = 2;

        return 1
                + area(grid, row - 1, col)
                + area(grid, row + 1, col)
                + area(grid, row, col - 1)
                + area(grid, row, col + 1);
    }
}
