package com.Zuo.Backtracking;

/*
【题目】
    N * N的棋盘，在皇后不同行，不同列，不同斜线的情况下，有多少摆放方式
 */
public class Nqueen
{
    public int methods(int n)
    {
        if(n < 1) return 0;

        int[] record = new int[n];
        return dfs(0,record,n);
    }

    //record[0...i-1]的皇后，任何两个皇后不共行，不共列，不共斜线
    //目前来到了第i行
    //record[0..i-1]表示之前的行，放置了皇后的位置
    //n 代表整体一共多少行 0-n-1行有效行
    //返回值是，摆完所有 皇后，合理的摆法有多少种
    public int dfs(int i ,int[] record, int n)
    {
        if(i == n)//i来到了终止行
            return 1;

        //没有到终止位置，还有皇后要摆
        int res = 0;
        for (int j = 0; j < n; j++)//这个j就是在当前来到i行的时候，对每一列就行尝试
        {
            if(isValid(record,i,j))
            {
                record[i] = j;//在这里就不还原现场了，也可以还
                res += dfs(i+1,record,n);
            }
        }
        return res;
    }

    //返回皇后放在i行j列是否有效
    public boolean isValid(int[] record, int i, int j)
    {
        for(int k = 0; k < i; k++)
        {
            /*
            (a,b) (c,d)
            只要满足，b == d, |a-c| == |b-d|就不达标

             皇后在k行，在record[k]列----现在进来的皇后在i行j列，对比这两个列，
             再对比行-行，列-列
             */
            if(j == record[k] || Math.abs(i-k) == Math.abs(record[k]-j))
                return false;
        }
        return true;
    }





    //位运算，更快，不遍历数组了,复杂度依旧是n的n次方，只是用位运算来优化常数的时间
    public int methods2(int n)
    {
        if(n < 1 || n > 32)  return 0;
        int limit = n == 32 ? -1 : (1 << n) -1;
        return dfs2(limit,0,0,0);
    }

    //limit划定了问题的规模，N皇后，几个皇后，limit最右边几个1，其他都是0
    //colLim ,列的限制，1的位置不能放皇后，0的位置可以
    //leftDiaLim ，左斜线的限制，1的位置不能放皇后，0的位置可以
    //rightDiaLim ，右斜线的限制，1的位置不能放皇后，0的位置可以
    public int dfs2(int limit,int colLim, int leftDiaLim, int rightDiaLim)
    {
        if(colLim == limit)  return 1;//说明所有列都点上1了

        //colLim | leftDiaLim | rightDiaLim 总限制
        //~(colLim | leftDiaLim | rightDiaLim)  总限制取反，就是可以用来放皇后的位置
        //但是前边的一串数字也反了，我们只要后面限制取反的位置，所以&上一个limit,limit正好是前面一串0，后面全是1
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));//所有可以选择皇后的位置，都在pos上

        int mostRight = 0;
        int res = 0;
        while(pos != 0)
        {
            //一个数与上它本身取反加1，就可以得到它右边所有的1，
            // 比如10100，我们第一次得到的应该是00100（最右边的1保留）
            //10100 & (01100)  --->(00100)
            mostRight = pos & (~pos + 1);

            pos = pos -mostRight;//把所有1全部取出来

            res += dfs2(limit,
                    colLim | mostRight,
                    (leftDiaLim | mostRight) << 1,
                    (rightDiaLim |mostRight) >>> 1 );
        }
        return res;
    }
}
