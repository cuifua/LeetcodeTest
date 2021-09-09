package com.Zuo.Backtracking;

/*
����Ŀ��
    N * N�����̣��ڻʺ�ͬ�У���ͬ�У���ͬб�ߵ�����£��ж��ٰڷŷ�ʽ
 */
public class Nqueen
{
    public int methods(int n)
    {
        if(n < 1) return 0;

        int[] record = new int[n];
        return dfs(0,record,n);
    }

    //record[0...i-1]�Ļʺ��κ������ʺ󲻹��У������У�����б��
    //Ŀǰ�����˵�i��
    //record[0..i-1]��ʾ֮ǰ���У������˻ʺ��λ��
    //n ��������һ�������� 0-n-1����Ч��
    //����ֵ�ǣ��������� �ʺ󣬺���İڷ��ж�����
    public int dfs(int i ,int[] record, int n)
    {
        if(i == n)//i��������ֹ��
            return 1;

        //û�е���ֹλ�ã����лʺ�Ҫ��
        int res = 0;
        for (int j = 0; j < n; j++)//���j�����ڵ�ǰ����i�е�ʱ�򣬶�ÿһ�о��г���
        {
            if(isValid(record,i,j))
            {
                record[i] = j;//������Ͳ���ԭ�ֳ��ˣ�Ҳ���Ի�
                res += dfs(i+1,record,n);
            }
        }
        return res;
    }

    //���ػʺ����i��j���Ƿ���Ч
    public boolean isValid(int[] record, int i, int j)
    {
        for(int k = 0; k < i; k++)
        {
            /*
            (a,b) (c,d)
            ֻҪ���㣬b == d, |a-c| == |b-d|�Ͳ����

             �ʺ���k�У���record[k]��----���ڽ����Ļʺ���i��j�У��Ա��������У�
             �ٶԱ���-�У���-��
             */
            if(j == record[k] || Math.abs(i-k) == Math.abs(record[k]-j))
                return false;
        }
        return true;
    }





    //λ���㣬���죬������������,���Ӷ�������n��n�η���ֻ����λ�������Ż�������ʱ��
    public int methods2(int n)
    {
        if(n < 1 || n > 32)  return 0;
        int limit = n == 32 ? -1 : (1 << n) -1;
        return dfs2(limit,0,0,0);
    }

    //limit����������Ĺ�ģ��N�ʺ󣬼����ʺ�limit���ұ߼���1����������0
    //colLim ,�е����ƣ�1��λ�ò��ܷŻʺ�0��λ�ÿ���
    //leftDiaLim ����б�ߵ����ƣ�1��λ�ò��ܷŻʺ�0��λ�ÿ���
    //rightDiaLim ����б�ߵ����ƣ�1��λ�ò��ܷŻʺ�0��λ�ÿ���
    public int dfs2(int limit,int colLim, int leftDiaLim, int rightDiaLim)
    {
        if(colLim == limit)  return 1;//˵�������ж�����1��

        //colLim | leftDiaLim | rightDiaLim ������
        //~(colLim | leftDiaLim | rightDiaLim)  ������ȡ�������ǿ��������Żʺ��λ��
        //����ǰ�ߵ�һ������Ҳ���ˣ�����ֻҪ��������ȡ����λ�ã�����&��һ��limit,limit������ǰ��һ��0������ȫ��1
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));//���п���ѡ��ʺ��λ�ã�����pos��

        int mostRight = 0;
        int res = 0;
        while(pos != 0)
        {
            //һ��������������ȡ����1���Ϳ��Եõ����ұ����е�1��
            // ����10100�����ǵ�һ�εõ���Ӧ����00100�����ұߵ�1������
            //10100 & (01100)  --->(00100)
            mostRight = pos & (~pos + 1);

            pos = pos -mostRight;//������1ȫ��ȡ����

            res += dfs2(limit,
                    colLim | mostRight,
                    (leftDiaLim | mostRight) << 1,
                    (rightDiaLim |mostRight) >>> 1 );
        }
        return res;
    }
}
