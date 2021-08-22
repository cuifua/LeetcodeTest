package com.top100.C_String.Palindrome;
/**
 * ����Ŀ��
 *      ����һ������ x ����� x ��һ���������������� true �����򣬷��� false ��
        ��������ָ���򣨴������ң��͵��򣨴������󣩶�����һ�������������磬121 �ǻ��ģ��� 123 ���ǡ�
 * �����⡿
 *      ���룺x = 121
 *      �����true
 *
 *      ���룺x = -121
 *      �����false
 *      ���ͣ��������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������
 *
 *      ���룺x = 10
 *      �����false
 *      ���ͣ����������, Ϊ 01 �����������һ����������
 * ��˼·��
 *      �ٸ����ӣ�1221 ������֡�
 *      ͨ������ 1221 / 1000�� ����λ1
 *      ͨ������ 1221 % 10�� �ɵ�ĩλ 1
 *      ���бȽ�
 *      �ٽ� 22 ȡ���������Ƚ�

 */
public class isPalindrome_9
{
    public boolean isPalindrome(int x)
    {
        //�߽��ж�
        if (x < 0) return false;

        int div = 1;
        while (x / div >= 10)
            div *= 10;

        while (x > 0)
        {
            int left = x / div;
            int right = x % 10;

            if (left != right)
                return false;

            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}