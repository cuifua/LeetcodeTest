package com.top100.J_Dynamic.islands;

/*

 */
public class islandsZhouChang_463
{
    public int islandPerimeter(int[][] grid)
    {
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[0].length; c++)
            {
                if (grid[r][c] == 1)
                    return dfs(grid, r, c);// ��Ŀ����ֻ��һ�����죬����һ������
            }
        }
        return 0;
    }

    int dfs(int[][] grid, int r, int c)
    {
        // ������Ϊ������ (r, c) ��������Χ�����أ���Ӧһ����ɫ�ı�
        if (!inArea(grid, r, c))
            return 1;

        // ������Ϊ����ǰ�����Ǻ�����ӡ����أ���Ӧһ����ɫ�ı�
        if (grid[r][c] == 0)
            return 1;

        // ������Ϊ����ǰ�������ѱ�����½�ظ��ӡ����أ����ܳ�û��ϵ
        if (grid[r][c] != 1)
            return 0;

        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }

    // �ж����� (r, c) �Ƿ���������
    boolean inArea(int[][] grid, int r, int c)
    {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }
}
