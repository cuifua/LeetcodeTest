package com.Company.XieCheng;

import java.util.Arrays;
import java.util.Scanner;
/*
时间限制： 3000MS
内存限制： 589824KB
【题目描述】
    有一个长度为n的序列A，序列中的第i个数为A[i] (1<=i<=n)，现在你可以将序列分成至多连续的k段。
    对于每一段，我们定义这一段的不平衡度为段内的最大值减去段内的最小值。显然，对于长度为1的段，其不平衡度为0。
    对于一种合法的分段方式（即每一段连续且不超过k段），我们定义这种分段方式的不平衡度为每一段的不平衡度的最大值。
    现在你需要找到不平衡度最小的分段方式，输出这种分段方式的不平衡度即可。

【输入描述】
    第一行两个空格隔开的整数n，k，分别表示序列的长度和最多可分成的段数。
    第二行是n个用空格隔开的整数，第i个数表示A[i]的值。

【输出描述】
    一行一个整数，表示最小的不平衡度。

【输入样例1】
    5 3
    3 5 5 2 5
【输出样例1】
    2
    解释：最终分为[3 5 5] [2] [5]，该种分段方式的不平衡度为2。

【输入样例2】
    5 4
    3 5 5 2 5
【输出样例2】
    0
    解释：最终分为[3] [5 5] [2] [5]

【输入样例3】
    4 2
    3 4 7 6
【输出样例3】
    1
    解释：例如对于序列[3, 4, 7, 6]，如果最多能分2段，那么分成[3, 4][7,6]的不平衡度为1，因为[3, 4]和[7, 6]的不平衡度都为1；
    而分成[3, 4, 7][6]的不平衡度为4，因为[3, 4, 7]的不平衡度为4，[6]的不平衡度为0，两段中不平衡度的最大值为4。
 */
public class NoBanlance
{
    public static int main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        return dfs(arr,k,0);
    }

    public static int dfs(int[] arr, int k,int index)
    {
        int n = arr.length-1;

        if(k == arr.length) //说明每段只有一个数，最大不平衡数就是自己减自己0
            return 0;

        if(k == 1)//如果只分了一段，直接排序数组，返回最大最小值的绝对值，就是不平衡数
        {
            Arrays.sort(arr);
            return arr[n]-arr[0];
        }

        for(int j = n; j >= 0; j--)
        {
            while(k-- > 0)
            {
                Arrays.sort(arr,index,j);
                int balance = arr[j] - arr[index];
                return Math.min(balance,dfs(arr,k,index+1));
            }
        }
        return -1;
    }

}
